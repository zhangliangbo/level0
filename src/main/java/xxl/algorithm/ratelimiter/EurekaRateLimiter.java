package xxl.algorithm.ratelimiter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangliangbo
 * @since 2021/11/14
 **/


@Slf4j
public class EurekaRateLimiter {

    private final long rateToMsConversion;

    private final AtomicInteger consumedTokens = new AtomicInteger();
    private final AtomicLong lastRefillTime = new AtomicLong(0);

    public EurekaRateLimiter(TimeUnit averageRateUnit) {
        switch (averageRateUnit) {
            case MILLISECONDS:
                rateToMsConversion = 1;
                break;
            case SECONDS:
                rateToMsConversion = 1000;
                break;
            case MINUTES:
                rateToMsConversion = 60 * 1000;
                break;
            default:
                throw new IllegalArgumentException("TimeUnit of " + averageRateUnit + " is not supported");
        }
    }

    public boolean acquire(int burstSize, long averageRate) {
        return acquire(burstSize, averageRate, System.currentTimeMillis());
    }

    public boolean acquire(int burstSize, long averageRate, long currentTimeMillis) {
        if (burstSize <= 0 || averageRate <= 0) {
            // Instead of throwing exception, we just let all the traffic go
            return true;
        }

        refillToken(burstSize, averageRate, currentTimeMillis);
        return consumeToken(burstSize);
    }

    private void refillToken(int burstSize, long averageRate, long currentTimeMillis) {
        long refillTime = lastRefillTime.get();
        long timeDelta = currentTimeMillis - refillTime;

        long newTokens = timeDelta * averageRate / rateToMsConversion;
        if (newTokens > 0) {
            long newRefillTime = refillTime == 0
                    ? currentTimeMillis
                    : refillTime + newTokens * rateToMsConversion / averageRate;
            if (lastRefillTime.compareAndSet(refillTime, newRefillTime)) {
                while (true) {
                    int currentLevel = consumedTokens.get();
                    // In case burstSize decreased
                    int adjustedLevel = Math.min(currentLevel, burstSize);
                    int newLevel = (int) Math.max(0, adjustedLevel - newTokens);
                    if (consumedTokens.compareAndSet(currentLevel, newLevel)) {
                        return;
                    }
                }
            }
        }
    }

    private boolean consumeToken(int burstSize) {
        while (true) {
            int currentLevel = consumedTokens.get();
            if (currentLevel >= burstSize) {
                return false;
            }
            if (consumedTokens.compareAndSet(currentLevel, currentLevel + 1)) {
                return true;
            }
        }
    }

    public void reset() {
        consumedTokens.set(0);
        lastRefillTime.set(0);
    }

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        EurekaRateLimiter rateLimiter = new EurekaRateLimiter(TimeUnit.SECONDS);
        while (true) {
            boolean elapsedSecond = rateLimiter.acquire(1, 1);
            if (elapsedSecond) {
                log.info("{} 获取 {}", Thread.currentThread(), System.nanoTime());
                ++count;
                if (count > 100) {
                    Thread.sleep(11000);
                    count = 0;
                }
            }
        }
    }

}
