package xxl.algorithm.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

/**
 * @author zhangliangbo
 * @since 2021/11/13
 **/


@Slf4j
public class GuavaRateLimiter {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        RateLimiter rateLimiter = RateLimiter.create(1D, Duration.ofSeconds(30));
        while (true) {
            boolean elapsedSecond = rateLimiter.tryAcquire();
            if (elapsedSecond) {
                log.info("{} 获取 {}", Thread.currentThread(), System.nanoTime());
                ++count;
                if (count > 100) {
                    Thread.sleep(15000);
                    count = 0;
                }
            }
        }
    }
}
