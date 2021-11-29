package xxl.algorithm.ratelimiter;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangliangbo
 * @since 2021/11/15
 **/

@Slf4j
public class RateLimiterTokenBucket {

    private final AtomicInteger consumedTokens = new AtomicInteger();
    private final Monitor monitor = new Monitor();
    private Monitor.Guard guard;
    private int burstSize;
    private RateLimiter rateLimiter;

    public RateLimiterTokenBucket(int burstSize, double averageRate) {
        this.burstSize = burstSize;
        this.rateLimiter = RateLimiter.create(averageRate);
        this.guard = monitor.newGuard(() -> consumedTokens.intValue() <= burstSize);
    }

    public boolean acquire(int size) {
        if (monitor.enterIf(guard)) {
            try {
                if (rateLimiter.tryAcquire()) {
                    while (true) {
                        int current = consumedTokens.get();
                        if (consumedTokens.compareAndSet(current, current + size)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            } finally {
                monitor.leave();
            }
        } else {
            return false;
        }
    }

    public boolean acquire() {
        return acquire(1);
    }

}
