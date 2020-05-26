package xxl.mathematica;


import java.util.List;
import java.util.function.Predicate;

/**
 * 全真
 */

public class AllTrue {
    /**
     * 如果对于所有的元素 t，p 均为 True，则生成 True.
     *
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> boolean allTrue(List<T> list, Predicate<T> p) {
        ObjectHelper.requireNonNull(list, p);
        for (T t : list) {
            if (!p.test(t)) {
                return false;
            }
        }
        return true;
    }
}
