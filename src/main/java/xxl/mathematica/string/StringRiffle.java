package xxl.mathematica.string;

import xxl.mathematica.ObjectHelper;
import xxl.mathematica.function.Function;

import java.util.List;

/**
 * 用分隔符连接字符串
 */
public class StringRiffle {

    public static <T> String stringRiffle(List<T> l, Function<T, String> f, String start, String splitter, String end) {
        ObjectHelper.requireNonNull(l, f, start, splitter, end);
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int i = 0; i < l.size() - 1; i++) {
            sb.append(f.apply(l.get(i))).append(splitter);
        }
        sb.append(f.apply(l.get(l.size() - 1)));
        sb.append(end);
        return sb.toString();
    }

    public static <T> String stringRiffle(List<T> l, String splitter) {
        return stringRiffle(l, new Function<T, String>() {
            @Override
            public String apply(T t) {
                return t.toString();
            }
        }, "", splitter, "");
    }

    public static <T> String stringRiffle(List<T> l) {
        return stringRiffle(l, " ");
    }
}
