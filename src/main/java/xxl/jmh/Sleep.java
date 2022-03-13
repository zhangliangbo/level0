package xxl.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangliangbo
 * @since 2021/11/30
 **/


public class Sleep {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void sleep1() throws InterruptedException {
        sleep(1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void sleep10() throws InterruptedException {
        sleep(10);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void sleep100() throws InterruptedException {
        sleep(100);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void sleep1000() throws InterruptedException {
        sleep(1000);
    }

    private void sleep(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }

}
