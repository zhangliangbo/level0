package xxl.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangliangbo
 * @since 2022/3/12
 */


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
@Threads(1)
@Measurement(iterations = 3)
@Warmup(iterations = 1)
public class PriorityQueueTest {

    @Setup
    public void setup() {

    }

    @TearDown
    public void tearDown() {

    }

    @Benchmark
    public void measure1000() {
        offer(1000);
    }

    @Benchmark
    public void measure2000() {
        offer(2000);
    }

    @Benchmark
    public void measure100000() {
        offer(4000);
    }

    @Benchmark
    public void measure8000() {
        offer(8000);
    }

    @Benchmark
    public void measure16000() {
        offer(16000);
    }

    private void offer(int size) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
        }
    }

}
