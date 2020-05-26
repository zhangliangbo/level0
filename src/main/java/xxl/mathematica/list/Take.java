package xxl.mathematica.list;

import java.util.List;

/**
 * 选取
 */

public class Take {

    /**
     * 给出list的前n个或者后n个元素
     *
     * @param list
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> take(List<T> list, int n) {
        if (n < 0) {
            return take(list, list.size() + n, list.size());
        } else {
            return take(list, 0, n);
        }
    }

    /**
     * 步长为1
     *
     * @param list
     * @param m
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> take(List<T> list, int m, int n) {
        return take(list, m, n, 1);
    }

    /**
     * 给出 list 中从 m（包括） 到 n（不包括） 的元素
     *
     * @param list
     * @param m
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> take(List<T> list, int m, int n, int step) {
        return io.vavr.collection.List.rangeBy(m < 0 ? m + list.size() : m, n < 0 ? n + list.size() : n, step)
                .map(list::get)
                .asJava();
    }

}
