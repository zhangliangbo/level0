package xxl.mathematica;

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

        ObjectHelper.requireNonNull(list);

        return list.size() == 0 ? def : list.get(0);
    }

    /**
     * 给出list的第一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T first(List<T> list) {
        ObjectHelper.requireNonNull(list);
        if (list.size() == 0) {
            throw new IllegalArgumentException("list's size is zero, do not have first element.");
        } else {
            return list.get(0);
        }
    }
}
