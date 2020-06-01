package xxl.mathematica.string;

import xxl.mathematica.function.Function;

import java.util.List;

/**
 * 连接字符串
 */
public class StringJoin {
    /**
     * 连接字符串
     *
     * @param list
     * @param f
     * @param <T>
     * @return
     */
    public static <T> String stringJoin(List<T> list, Function<T, String> f) {
        return io.vavr.collection.List.ofAll(list)
                .map(f::apply)
                .mkString();

    }

    /**
     * 连接字符串
     *
     * @param l
     * @param <T>
     * @return
     */
    public static <T> String stringJoin(List<T> l) {
        return stringJoin(l, Object::toString);
    }
}
