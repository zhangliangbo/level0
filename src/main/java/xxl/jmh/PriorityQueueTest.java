package xxl.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangliangbo
 * @since 2022/3/12
 */
public class PriorityQueueTest {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void measure100() {
        offer(100);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void measure1000() {
        offer(1000);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void measure10000() {
        offer(10000);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    @Measurement(iterations = 3)
    @Warmup(iterations = 1)
    public void measure100000() {
        offer(100000);
    }

    private void offer(int size) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
        }
    }

}
