package xxl.mathematica;

import xxl.mathematica.function.BiFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 折叠列表
 */

public class FoldList {
    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param initValue
     * @param list      列表
     * @param <T>
     * @return
     */
    public static <T> List<T> foldList(BiFunction<T, T, T> function, T initValue, List<T> list) {

        ObjectHelper.requireNonNull(function, initValue, list);

        List<T> result = new ArrayList<>(1);
        result.add(initValue);
        T last = initValue;//上一个是第一个
        for (T cur : list) {
            T next = function.apply(last, cur);
            result.add(next);
            last = next;//重置上一个
        }
        return result;
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
    public static <T> List<T> foldList(BiFunction<T, T, T> function, T initValue, T[] array) {

        return foldList(function, initValue, Arrays.asList(array));
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param list     列表
     * @param <T>
     * @return
     */
    public static <T> List<T> foldList(BiFunction<T, T, T> function, List<T> list) {

        ObjectHelper.requireNonNull(function, list);
        ObjectHelper.requireLengthNotLessThan(list, 1, "list");

        List<T> result = new ArrayList<T>(1);
        result.add(list.get(0));
        T last = list.get(0);//上一个是第一个
        for (int i = 1; i < list.size(); i++) {
            T cur = list.get(i);
            T next = function.apply(last, cur);
            result.add(next);
            last = next;//重置上一个
        }
        return result;
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param array    数组
     * @param <T>
     * @return
     */
    public static <T> List<T> foldList(BiFunction<T, T, T> function, T[] array) {

        return foldList(function, Arrays.asList(array));
    }
}
