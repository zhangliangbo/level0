package xxl.mathematica.list;

import java.util.Comparator;
import java.util.List;

/**
 * 排序
 */

public class Sort {

    /**
     * 用排序函数 p 对元素排序
     *
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> sort(List<T> list, Comparator<T> p) {
        return io.vavr.collection.List.ofAll(list)
                .sorted(p)
                .asJava();
    }

    /**
     * 自然顺序
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        return sort(list, Comparator.naturalOrder());
    }
}
