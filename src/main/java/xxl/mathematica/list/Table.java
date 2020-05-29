package xxl.mathematica.list;

import xxl.mathematica.function.BiFunction;
import xxl.mathematica.function.Function;

import java.util.List;

/**
 * 表格
 */

public class Table {

    /**
     * 根据离散点来生成表
     *
     * @param function
     * @param list
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> table(Function<T, R> function, List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .map(function::apply)
                .asJava();
    }

    /**
     * 根据离散点列表来生成二维表
     *
     * @param function
     * @param list1
     * @param list2
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<List<R>> table(BiFunction<T, T, R> function, List<T> list1, List<T> list2) {
        return io.vavr.collection.List.ofAll(list1)
                .map(t1 -> io.vavr.collection.List.ofAll(list2)
                        .map(t2 -> function.apply(t1, t2))
                        .asJava())
                .asJava();
    }

}
