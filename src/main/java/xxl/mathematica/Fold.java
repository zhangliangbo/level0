package xxl.mathematica;

import xxl.mathematica.function.BiFunction;

import java.util.Arrays;
import java.util.List;

/**
 * 折叠
 */

public class Fold {
    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param initValue
     * @param list      列表
     * @param <T>
     * @return
     */
    public static <T> T fold(BiFunction<T, T, T> function, T initValue, List<T> list) {

        ObjectHelper.requireNonNull(function, initValue, list);

        T last = initValue;//上一个是第一个
        for (T cur : list) {
            last = function.apply(last, cur);//重置上一个
        }
        return last;
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param initValue
     * @param array     数组
     * @param <T>
     * @return
     */
    public static <T> T fold(BiFunction<T, T, T> function, T initValue, T[] array) {

        return fold(function, initValue, Arrays.asList(array));
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param list     列表
     * @param <T>
     * @return
     */
    public static <T> T fold(BiFunction<T, T, T> function, List<T> list) {

        ObjectHelper.requireNonNull(function, list);
        ObjectHelper.requireLengthNotLessThan(list, 1, "list");

        T last = list.get(0);//上一个是第一个
        for (int i = 1; i < list.size(); i++) {
            T cur = list.get(i);
            last = function.apply(last, cur);//重置上一个
        }
        return last;
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param array    数组
     * @param <T>
     * @return
     */
    public static <T> T fold(BiFunction<T, T, T> function, T[] array) {

        return fold(function, Arrays.asList(array));
    }
}
