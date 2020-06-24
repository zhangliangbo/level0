package xxl.mathematica.list;


import xxl.mathematica.ObjectHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 选择
 */

public class Select {
    /**
     * 选取 list 中使得 criteria 为 True 的所有元素.
     *
     * @param list
     * @param criteria
     * @param <T>
     * @return
     */
    public static <T> List<T> select(List<T> list, Predicate<T> criteria) {
        return io.vavr.collection.List.ofAll(list)
                .filter(criteria)
                .asJava();
    }

    /**
     * 选取 list 中使得 criteria 为 True 的前 n 个元素.
     *
     * @param list
     * @param criteria
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> select(List<T> list, Predicate<T> criteria, int n) {
        return io.vavr.collection.List.ofAll(list)
                .filter(criteria)
                .take(n)
                .asJava();
    }
}
