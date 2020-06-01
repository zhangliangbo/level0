package xxl.mathematica.functional;


import io.vavr.control.Try;

import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 返回一个将 function 作用于 object 上 n 次后得到的表达式.
 */

public class Nest {
    /**
     * 将函数作用于一个对象上n次，并返回最终结果
     *
     * @param function
     * @param initValue
     * @param n
     * @param <T>
     * @return
     */
    public static <T> T nest(Function<T, T> function, T initValue, int n) {
        return Try.ofCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                T temp = initValue;
                for (int i = 0; i < n; i++) {
                    temp = function.apply(temp);
                }
                return temp;
            }
        }).getOrNull();
    }
}
