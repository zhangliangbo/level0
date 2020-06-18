package xxl.mathematica.list;

import java.util.List;

/**
 * 第一个
 */

public class First {
    /**
     * 如果存在则给出第一个元素，否则返回def
     *
     * @param list
     * @param def
     * @param <T>
     * @return
     */
    public static <T> T first(List<T> list, T def) {
        return io.vavr.collection.List.ofAll(list)
                .headOption()
                .getOrElse(def);
    }

    /**
     * 给出list的第一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T first(List<T> list) {
        return first(list, null);
    }
}
