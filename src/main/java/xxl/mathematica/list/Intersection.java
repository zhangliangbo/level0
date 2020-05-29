package xxl.mathematica.list;

import java.util.Comparator;
import java.util.List;

/**
 * 交集
 */
public class Intersection {
    /**
     * comparable
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> List<T> intersection(List<T> list1, List<T> list2) {
        Comparator<T> comparator = Comparable::compareTo;
        return intersection(list1, list2, comparator);
    }

    /**
     * 两个集合的交集
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> List<T> intersection(List<T> list1, List<T> list2, Comparator<T> comparator) {
        return io.vavr.collection.List.ofAll(list1)
                .distinctBy(comparator)
                .filter(t1 -> io.vavr.collection.List.ofAll(list2)
                        .distinctBy(comparator)
                        .exists(t2 -> comparator.compare(t1, t2) == 0))
                .sorted(comparator)
                .asJava();
    }
}
