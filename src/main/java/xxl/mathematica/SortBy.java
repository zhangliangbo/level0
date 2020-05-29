package xxl.mathematica;

import xxl.mathematica.function.Function;
import xxl.mathematica.list.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序方式
 */
public class SortBy {
    /**
     * 转换函数f作用于T得到的R，并根据R的排序函数p来排序
     *
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R extends Comparable<? super R>> List<T> sortBy(List<T> list, Function<T, R> f, Comparator<R> p) {
        ObjectHelper.requireNonNull(list, f);
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return p.compare(f.apply(o1), f.apply(o2));
            }
        });
        return new ArrayList<>(list);
    }

    /**
     * 根据R的自然排序函数来排序
     *
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R extends Comparable<? super R>> List<T> sortBy(List<T> list, Function<T, R> f) {
        return sortBy(list, f, Sort.naturalOrder());
    }
}
