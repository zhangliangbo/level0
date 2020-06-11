package xxl.mathematica.list;

import java.util.List;

/**
 * 等分划分
 */
public class Subdivide {
    /**
     * 双精度浮点型
     *
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static List<Double> subdivide(double min, double max, int n) {
        return io.vavr.collection.List.rangeClosedBy(min, max, (max - min) / n)
                .asJava();
    }

    /**
     * 长整型
     *
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static List<Long> subdivide(long min, long max, int n) {
        return io.vavr.collection.List.ofAll(subdivide((double) min, (double) max, n))
                .map(Math::round).asJava();
    }

    /**
     * 整型
     *
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static List<Integer> subdivide(int min, int max, int n) {
        return io.vavr.collection.List.ofAll(subdivide((double) min, max, n))
                .map(aDouble -> (int) Math.round(aDouble)).asJava();
    }

}
