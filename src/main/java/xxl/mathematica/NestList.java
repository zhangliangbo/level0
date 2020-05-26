package xxl.mathematica;

import xxl.mathematica.function.Function;

import java.util.ArrayList;
import java.util.List;

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
        ObjectHelper.requireNonNull(function, initValue);
        ObjectHelper.requireNonNegative(n);

        List<T> result = new ArrayList<T>(n + 1);
        T input = initValue;
        result.add(input);
        for (int i = 0; i < n; i++) {
            T output = function.apply(input);
            result.add(output);
            input = output;
        }
        return result;
    }
}
