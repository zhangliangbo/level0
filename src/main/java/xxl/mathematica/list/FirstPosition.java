package xxl.mathematica.list;

import io.vavr.Tuple2;

import java.util.List;
import java.util.function.Predicate;


/**
 * 第一个匹配的位置
 */

public class FirstPosition {
    /**
     * 没有匹配项直接抛异常
     *
     * @param list
     * @param criteria
     * @param <T>
     * @return
     */
    public static <T> int firstPosition(List<T> list, Predicate<T> criteria) {
        return io.vavr.collection.List.ofAll(list)
            .zipWithIndex()
            .find(tIntegerTuple2 -> criteria.test(tIntegerTuple2._1))
            .map(Tuple2::_2)
            .get();
    }

    /**
     * 没有匹配项，给出默认值
     *
     * @param list
     * @param criteria
     * @param def
     * @param <T>
     * @return
     */
    public static <T> int firstPosition(List<T> list, Predicate<T> criteria, int def) {
        return io.vavr.collection.List.ofAll(list)
            .zipWithIndex()
            .find(tIntegerTuple2 -> criteria.test(tIntegerTuple2._1))
            .map(Tuple2::_2)
            .getOrElse(def);
    }
}
