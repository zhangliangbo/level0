package xxl.mathematica.random;

import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 伪随机采样
 */
public class RandomSample {
    /**
     * 不重复随机采样
     *
     * @param list
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> randomSample(List<T> list, final int n) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> rest = new ArrayList<>(list);
                int num = n;
                if (num > list.size()) {
                    num = list.size();
                }
                return io.vavr.collection.List.range(0, num)
                        .map(new Function<Integer, T>() {
                            @Override
                            public T apply(Integer integer) {
                                return rest.remove(RandomInteger.randomInteger(rest.size()));
                            }
                        }).asJava();
            }
        }).get();
    }
}
