package xxl.mathematica;


import java.util.List;
import java.util.function.Predicate;

/**
 * 任一为真
 */

public class AnyTrue {
    /**
     * 如果 p 对于任意一个 t 为 True，则生成 True.
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> boolean anyTrue(List<T> list, Predicate<T> predicate) {
        ObjectHelper.requireNonNull(list, predicate);

        for (T t : list) {
            if (predicate.test(t)) {
                return true;
            }
        }

        return false;
    }
}
