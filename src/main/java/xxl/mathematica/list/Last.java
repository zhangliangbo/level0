package xxl.mathematica.list;

import java.util.List;

/**
 * 最后一个
 */

public class Last {
    /**
     * 给出list的最后一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T last(List<T> list) {
        return last(list, null);
    }

    /**
     * 如果有任何元素给出最后一个元素，否则给出 def
     *
     * @param list
     * @param def
     * @param <T>
     * @return
     */
    public static <T> T last(List<T> list, T def) {
        return io.vavr.collection.List.ofAll(list)
                .lastOption()
                .getOrElse(def);
    }
}
