package xxl.mathematica.list;

import io.vavr.Tuple2;

import java.util.Comparator;
import java.util.List;

/**
 * 排序索引
 */
public class Ordering {
    /**
     * 指定排序器
     *
     * @param list
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T> List<Integer> ordering(List<T> list, Comparator<T> comparator) {
        return io.vavr.collection.List.ofAll(list)
                .zipWithIndex()
                .sorted((o1, o2) -> comparator.compare(o1._1(), o2._1()))
                .map(Tuple2::_2)
                .toJavaList();
    }

    /**
     * 可排序的项
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> List<Integer> ordering(List<T> list) {
        return ordering(list, Comparator.naturalOrder());
    }
}
