package xxl.mathematica.list;

import xxl.mathematica.function.Function;

import java.util.List;

/**
 * 数组
 */

public class Array {
    /**
     * 以0为起点
     *
     * @param function
     * @param n
     * @param <R>
     * @return
     */
    public static <R> List<R> array(Function<Integer, R> function, int n) {
        return array(function, n, 0);
    }

    /**
     * 以r为起点生成n个值
     *
     * @param function
     * @param n        生成n个值
     * @param r        以r为起点
     * @param <R>
     * @return
     */
    public static <R> List<R> array(Function<Integer, R> function, int n, int r) {
        return io.vavr.collection.List.rangeBy(r, r + n, 1)
                .map(function::apply)
                .asJava();
    }
}
