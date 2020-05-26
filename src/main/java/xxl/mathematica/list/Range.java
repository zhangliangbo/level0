package xxl.mathematica.list;

import java.util.List;

/**
 * 范围，严格以上不允许实例化
 */

public class Range<T> {

    private Range() {
    }

    /**
     * 从0（包括）到max（不包括）的列表
     *
     * @param max
     * @return
     */
    public static List<Integer> range(int max) {
        return range(0, max);
    }

    /**
     * @param min 制定下界
     * @param max
     * @return
     */
    public static List<Integer> range(int min, int max) {
        return range(min, max, 1);
    }

    /**
     * @param min
     * @param max
     * @param step 指定步长，可大可小
     * @return
     */
    public static List<Integer> range(int min, int max, int step) {
        return io.vavr.collection.List.rangeBy(min, max, step)
                .asJava();
    }

    /**
     * 从0（包括）到max（不包括）的列表
     *
     * @param max
     * @return
     */
    public static List<Long> range(long max) {
        return range(0L, max);
    }

    /**
     * @param min 制定下界
     * @param max
     * @return
     */
    public static List<Long> range(long min, long max) {
        return range(min, max, 1);
    }

    /**
     * @param min
     * @param max
     * @param step 指定步长，可大可小
     * @return
     */
    public static List<Long> range(long min, long max, long step) {
        return io.vavr.collection.List.rangeBy(min, max, step)
                .asJava();
    }

    /**
     * @param min
     * @param max
     * @return
     */
    public static List<Character> range(char min, char max) {
        return range(min, max, 1);
    }

    /**
     * @param min
     * @param max
     * @param step 指定步长，可大可小
     * @return
     */
    public static List<Character> range(char min, char max, int step) {
        return io.vavr.collection.List.rangeBy(min, max, step)
                .asJava();
    }


    /**
     * 从0（包括）到max（不包括）的列表
     *
     * @param max
     * @return
     */
    public static List<Double> range(double max) {
        return range(0D, max);
    }

    /**
     * @param min 制定下界
     * @param max
     * @return
     */
    public static List<Double> range(double min, double max) {
        return range(min, max, 1D);
    }

    /**
     * @param min
     * @param max
     * @param step 指定步长，可大可小
     * @return
     */
    public static List<Double> range(double min, double max, double step) {
        return io.vavr.collection.List.rangeBy(min, max, step)
                .asJava();
    }
}
