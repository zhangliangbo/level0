package xxl.mathematica.string;

import xxl.mathematica.ObjectHelper;
import xxl.mathematica.function.Function;

import java.util.List;

/**
 * 连接字符串
 */
public class StringJoin {

    public static <T> String stringJoin(List<T> l, Function<T, String> f) {
        ObjectHelper.requireNonNull(l, f);
        StringBuilder sb = new StringBuilder();
        for (T t : l) {
            sb.append(f.apply(t));
        }
        return sb.toString();
    }

    public static <T> String stringJoin(List<T> l) {
        return stringJoin(l, new Function<T, String>() {
            @Override
            public String apply(T t) {
                return t.toString();
            }
        });
    }
}
