package xxl.mathematica.list;

import java.util.Comparator;
import java.util.List;

/**
 * 补集
 */
public class Complement {
    /**
     * 属于list1但不属于list2的元素
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> List<T> complement(List<T> list1, List<T> list2) {
        Comparator<T> comparator = Comparable::compareTo;
        return complement(list1, list2, comparator);
    }

    /**
     * 属于list1但不属于list2的元素
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> List<T> complement(List<T> list1, List<T> list2, Comparator<T> comparator) {
        return io.vavr.collection.List.ofAll(list1)
                .distinctBy(comparator)
                .filter(t1 -> !io.vavr.collection.List.ofAll(list2)
                        .distinctBy(comparator)
                        .exists(t2 -> comparator.compare(t1, t2) == 0))
                .sorted(comparator)
                .asJava();
    }
}
