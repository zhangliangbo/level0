package xxl.mathematica.list;

import java.util.List;
import java.util.function.Predicate;

/**
 * 计数
 */

public class Count {
    /**
     * 给出 list 中匹配 p 的元素个数.
     *
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> int count(List<T> list, Predicate<T> p) {
        return io.vavr.collection.List.ofAll(list)
                .count(p);
    }
}
