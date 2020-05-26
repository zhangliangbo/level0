package xxl.mathematica.list;

import java.util.Comparator;
import java.util.List;

/**
 * 并集
 */
public class Union {
    /**
     * comparable
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> List<T> union(List<T> list) {
        Comparator<T> comparator = Comparable::compareTo;
        return union(list, comparator);
    }

    /**
     * 对列表进行排序，删除重复元素
     *
     * @param list
     * @param sameTest
     * @param <T>
     * @return
     */
    public static <T> List<T> union(List<T> list, Comparator<T> sameTest) {
        return io.vavr.collection.List.ofAll(list)
                .distinctBy(sameTest)
                .sorted(sameTest)
                .asJava();
    }

    /**
     * comparable
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> List<T> union(List<T> list1, List<T> list2) {
        Comparator<T> comparator = Comparable::compareTo;
        return union(list1, list2, comparator);
    }

    /**
     * 给出多个列表中所有不同元素的有序列表
     *
     * @param list1
     * @param list2
     * @param sameTest
     * @param <T>
     * @return
     */
    public static <T> List<T> union(List<T> list1, List<T> list2, Comparator<T> sameTest) {
        return io.vavr.collection.List.ofAll(list1)
                .appendAll(list2)
                .distinctBy(sameTest)
                .sorted(sameTest)
                .asJava();
    }

}
