package xxl.algorithm.ratelimiter;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import xxl.mathematica.function.Consumer;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangliangbo
 * @since 2021/11/14
 **/


@Slf4j
public class RateLimiterBucket {
    private final ConcurrentLinkedQueue<Request> bucket = new ConcurrentLinkedQueue<>();
    private final static int BUCKET_CAPACITY = 1000;
    private final RateLimiter rateLimiter = RateLimiter.create(10.0D);
    private final Monitor requestMonitor = new Monitor();
    private final Monitor handleMonitor = new Monitor();

    public void submitRequest(int data) {
        this.submitRequest(new Request(data));
    }

    public void submitRequest(Request request) {
        if (requestMonitor.enterIf(requestMonitor.newGuard(() -> bucket.size() < BUCKET_CAPACITY))) {
            try {
                boolean result = bucket.offer(request);
                if (result) {
                    log.info("{} succeed {}", Thread.currentThread().getName(), request.getData());
                } else {
                    log.info("{} fail {}", Thread.currentThread().getName(), request.getData());
                }
            } finally {
                requestMonitor.leave();
            }
        } else {
            log.info("{} overflow {}", Thread.currentThread().getName(), request.getData());
        }
    }

    public void handleRequest(Consumer<Request> consumer) {
        if (handleMonitor.enterIf(handleMonitor.newGuard(() -> !bucket.isEmpty()))) {
            try {
                rateLimiter.acquire();
                consumer.accept(bucket.poll());
            } finally {
                handleMonitor.leave();
            }
        }
    }
}
