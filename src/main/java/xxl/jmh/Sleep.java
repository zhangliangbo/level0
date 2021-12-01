package xxl.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangliangbo
 * @since 2021/11/30
 **/


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Measurement(iterations = 5)
@Warmup(iterations = 3)
public class Sleep {

    @Benchmark
    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(Sleep.class.getSimpleName())
                .forks(1)
                .measurementIterations(5)
                .warmupIterations(3)
                .build();
        Collection<RunResult> run = new Runner(options).run();
        System.err.println(run);
    }

}
