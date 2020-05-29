package xxl.mathematica.list;

import java.util.LinkedList;
import java.util.List;

/**
 * 去掉元素
 */

public class Drop {
    /**
     * 去掉list的前n个或者后n个元素
     *
     * @param list
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> drop(List<T> list, int n) {
        if (n < 0) {
            return drop(list, list.size() + n, list.size());
        } else {
            return drop(list, 0, n);
        }
    }

    /**
     * 去掉 list 的从 m（包括） 到 n（不包括） 的元素
     *
     * @param list
     * @param m
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> drop(List<T> list, int m, int n) {
        return drop(list, m, n, 1);
    }

    /**
     * 去掉 list 的从m（包括） 到 n（不包括） 的元素，步长为 s
     *
     * @param list
     * @param m
     * @param n
     * @param step
     * @param <T>
     * @return
     */
    public static <T> List<T> drop(List<T> list, int m, int n, int step) {
        return io.vavr.collection.List.of(list)
                .map(ts -> {
                    List<T> res = new LinkedList<>(ts);
                    io.vavr.collection.List.rangeBy(m < 0 ? ts.size() + m : m, n < 0 ? ts.size() + n : n, step)
                            .sorted()
                            .reverse()
                            .forEach(integer -> {
                                int cur = integer;
                                res.remove(cur);
                            });
                    return res;
                })
                .get();

    }
}
