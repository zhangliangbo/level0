package xxl.mathematica.list;


import java.util.List;
import java.util.function.Predicate;


/**
 * 位置
 */

public class Position {
    /**
     * equals判断相等
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<Integer> position(List<T> list, T t) {
        Predicate<T> predicate = cur -> cur.equals(t);
        return position(list, predicate);
    }

    /**
     * 给出找到对象的位置
     *
     * @param list
     * @param criteria
     * @param <T>
     * @return
     */
    public static <T> List<Integer> position(List<T> list, Predicate<T> criteria) {
        return io.vavr.collection.List.ofAll(list)
                .zipWithIndex()
                .filter(tuple2 -> criteria.test(tuple2._1))
                .map(tuple2 -> tuple2._2)
                .asJava();
    }
}
