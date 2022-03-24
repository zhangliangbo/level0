package xxl.jmh;

import org.apache.commons.lang.math.RandomUtils;
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
@State(Scope.Benchmark)
public class PriorityQueueTest {

    private final Integer[] data = new Integer[100000];

    @Setup(Level.Iteration)
    public void su() {
        for (int i = 0; i < 100000; i++) {
            int random = RandomUtils.nextInt(100000);
            data[i] = random;
        }
    }

    @TearDown(Level.Iteration)
    public void td() {

    }

    @Benchmark
    public void measure100() {
        offer(100);
    }

    @Benchmark
    public void measure1000() {
        offer(1000);
    }

    @Benchmark
    public void measure10000() {
        offer(10000);
    }

    @Benchmark
    public void measure100000() {
        offer(100000);
    }

    private void offer(int size) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(data[i]);
        }
    }

}
