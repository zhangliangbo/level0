package xxl.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

/**
 * @author zhangliangbo
 * @since 2022/3/26
 */
public class Micrometer {
    public static void main(String[] args) {
        MeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

        Counter counter = Counter
                .builder("counter")
                .baseUnit("beans") // optional
                .description("a description of what this counter does") // optional
                .tags("region", "test") // optional
                .register(registry);

        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}
