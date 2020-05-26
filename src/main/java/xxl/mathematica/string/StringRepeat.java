package xxl.mathematica.string;

import xxl.mathematica.ObjectHelper;
import xxl.mathematica.function.Function;

/**
 * 重复字符串
 */
public class StringRepeat {

    public static <T> String stringRepeat(T t, Function<T, String> f, int times) {
        ObjectHelper.requireNonNull(t, f);
        ObjectHelper.requirePositive(times);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(f.apply(t));
        }
        return sb.toString();
    }

    public static <T> String stringRepeat(T t, int times) {
        return stringRepeat(t, new Function<T, String>() {
            @Override
            public String apply(T t) {
                return t.toString();
            }
        }, times);
    }

    public static <T> String stringRepeat(T t, Function<T, String> f, int times, int max) {
        ObjectHelper.requireNonNull(t, f);
        ObjectHelper.requirePositive(times, max);
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
    }

    public static <T> String stringRepeat(T t, int times, int max) {
        return stringRepeat(t, new Function<T, String>() {
            @Override
            public String apply(T t) {
                return t.toString();
            }
        }, times, max);
    }
}
