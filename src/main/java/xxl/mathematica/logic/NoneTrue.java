package xxl.mathematica.logic;


import java.util.List;
import java.util.function.Predicate;

/**
 * 非真判定
 */

public class NoneTrue {
    /**
     * 判断list是否所有的元素都满足p
     *
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> boolean noneTrue(List<T> list, Predicate<T> p) {
        return io.vavr.collection.List.ofAll(list)
                .find(p)
                .isEmpty();
    }
}
