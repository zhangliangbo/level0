package xxl.mathematica.logic;


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
        return io.vavr.collection.List.ofAll(list)
                .find(predicate)
                .isDefined();
    }
}
