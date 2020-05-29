package xxl.mathematica;

import xxl.mathematica.function.Consumer;

import java.util.List;

/**
 * Do循环
 */

public class Do {
    /**
     * 对 function 计算 n 次.
     *
     * @param consumer
     * @param n
     */
    public static void loop(Consumer<Integer> consumer, int n) {
        loop(consumer, 0, n);
    }

    /**
     * 从 min（包括）开始，到max（不包括）结束，步长为1
     *
     * @param consumer
     * @param min
     * @param max
     */
    public static void loop(Consumer<Integer> consumer, int min, int max) {
        loop(consumer, min, max, 1);
    }

    /**
     * 从 min（包括）开始，到max（不包括）结束，步长为d
     *
     * @param consumer
     * @param min
     * @param max
     * @param d
     */
    public static void loop(Consumer<Integer> consumer, int min, int max, int d) {
        ObjectHelper.requireNonNull(consumer);
        ObjectHelper.requireAscend(min, max, "min", "max");
        ObjectHelper.requireNonZero(d, "d");
        if (d < 0) {
            for (int i = max; i > min; i += d) {
                consumer.accept(i);
            }
        } else {
            for (int i = min; i < max; i += d) {
                consumer.accept(i);
            }
        }
    }

    /**
     * 使用离散的值.
     *
     * @param consumer
     * @param list
     */
    public static void loop(Consumer<Integer> consumer, List<Integer> list) {
        ObjectHelper.requireNonNull(consumer, list);
        for (Integer integer : list) {
            consumer.accept(integer);
        }
    }
}
