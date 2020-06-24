package xxl.mathematica.list;


import java.util.List;
import java.util.function.Predicate;

/**
 * 条件选取
 */

public class TakeWhile {
    /**
     * 从 list 的第一个元素开始 ，列出满足 criteria 条件的元素
     *
     * @param list
     * @param criteria
     * @param <T>
     * @return
     */
    public static <T> List<T> takeWhile(List<T> list, Predicate<T> criteria) {
        return io.vavr.collection.List.ofAll(list)
                .filter(criteria)
                .asJava();
    }
}
