package xxl.mathematica;


import java.util.ArrayList;
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
        ObjectHelper.requireNonNull(list, criteria);
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (criteria.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
