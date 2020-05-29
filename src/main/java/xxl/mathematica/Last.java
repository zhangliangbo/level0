package xxl.mathematica;

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
        ObjectHelper.requireNonNull(list);
        if (list.size() == 0) {
            throw new IllegalArgumentException("list's size is zero, do not have last element");
        } else {
            return list.get(list.size() - 1);
        }
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
        ObjectHelper.requireNonNull(list);
        if (list.size() == 0) {
            return def;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
