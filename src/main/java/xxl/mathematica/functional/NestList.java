package xxl.mathematica.functional;

import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 嵌套列表
 */

public class NestList {
    /**
     * 将函数作用于一个对象上n次，并返回中间过程列表
     *
     * @param function
     * @param initValue
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> nestList(Function<T, T> function, T initValue, int n) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> res = new ArrayList<>();
                T temp = initValue;
                res.add(temp);
                for (int i = 0; i < n; i++) {
                    temp = function.apply(temp);
                    res.add(temp);
                }
                return res;
            }
        }).getOrNull();
    }
}
