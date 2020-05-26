package xxl.mathematica;

import java.util.ArrayList;

/**
 * 等分划分
 */

public class Subdivide<T> extends ArrayList<T> {
    /**
     * 把0-1分成n等分
     *
     * @param n
     * @return
     */
    public static Subdivide<Double> subdivide(int n) {

        ObjectHelper.requireNonNegative(n, "n");
        Subdivide<Double> result = new Subdivide<>();

        double interval = 1D / n;
        for (int i = 0; i <= n; i++) {
            result.add(i * interval);
        }
        return result;
    }

    /**
     * 把0-max分成n等分
     *
     * @param max
     * @param n
     * @return
     */
    public static Subdivide<Double> subdivide(double max, int n) {
        ObjectHelper.requireNonNegative(n, "n");

        Subdivide<Double> result = new Subdivide<>();
        double interval = max / n;
        for (int i = 0; i <= n; i++) {
            result.add(i * interval);
        }
        return result;
    }

    /**
     * 把min和max分成n等分
     *
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static Subdivide<Double> subdivide(double min, double max, int n) {
        ObjectHelper.requireNonNegative(n, "n");

        Subdivide<Double> result = new Subdivide<>();
        double interval = (max - min) / n;
        for (int i = 0; i <= n; i++) {
            result.add(min + interval * i);
        }
        return result;
    }

}
