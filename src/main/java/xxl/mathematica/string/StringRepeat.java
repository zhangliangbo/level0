package xxl.mathematica.string;

import io.vavr.control.Try;
import xxl.mathematica.function.Function;

/**
 * 重复字符串
 */
public class StringRepeat {
    /**
     * 重复字符串n次
     *
     * @param t
     * @param f
     * @param times
     * @param <T>
     * @return
     */
    public static <T> String stringRepeat(T t, Function<T, String> f, int times) {
        return Try.ofCallable(() -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < times; i++) {
                sb.append(f.apply(t));
            }
            return sb.toString();
        }).getOrNull();
    }

    /**
     * 使用toString()方法
     *
     * @param t
     * @param times
     * @param <T>
     * @return
     */
    public static <T> String stringRepeat(T t, int times) {
        return stringRepeat(t, Object::toString, times);
    }

    /**
     * 重复字符串，超过最大字符截断
     *
     * @param t
     * @param f
     * @param times
     * @param max
     * @param <T>
     * @return
     */
    public static <T> String stringRepeat(T t, Function<T, String> f, int times, int max) {
        return Try.ofCallable(() -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < times; i++) {
                String r = f.apply(t);
                r = (r == null ? "null" : r);
                if (sb.length() + r.length() > max) {
                    sb.append(r, 0, max - sb.length());
                } else {
                    sb.append(r);
                }
            }
            return sb.toString();
        }).getOrNull();
    }

    /**
     * 默认使用toString()方法
     *
     * @param t
     * @param times
     * @param max
     * @param <T>
     * @return
     */
    public static <T> String stringRepeat(T t, int times, int max) {
        return stringRepeat(t, Object::toString, times, max);
    }
}
