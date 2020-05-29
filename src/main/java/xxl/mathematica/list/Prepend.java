package xxl.mathematica.list;

import java.util.List;

/**
 * 加在前面
 */

public class Prepend {
    /**
     * 在 list 前加 elem.
     *
     * @param list
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> prepend(List<T> list, T t) {
        return io.vavr.collection.List.ofAll(list)
                .prepend(t)
                .asJava();
    }
}
