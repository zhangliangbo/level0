package xxl.mathematica.string;

import xxl.mathematica.function.Function;

import java.util.List;

/**
 * 用分隔符连接字符串
 */
public class StringRiffle {
    /**
     * 指定开头 分隔符 结尾
     *
     * @param l
     * @param f
     * @param start
     * @param splitter
     * @param end
     * @param <T>
     * @return
     */
    public static <T> String stringRiffle(List<T> l, Function<T, String> f, String start, String splitter, String end) {
        return io.vavr.collection.List.ofAll(l)
                .map(f::apply)
                .mkString(start, splitter, end);
    }

    /**
     * 开头和结尾为“”
     *
     * @param l
     * @param splitter
     * @param <T>
     * @return
     */
    public static <T> String stringRiffle(List<T> l, String splitter) {
        return stringRiffle(l, Object::toString, "", splitter, "");
    }

    /**
     * 默认空格分割
     *
     * @param l
     * @param <T>
     * @return
     */
    public static <T> String stringRiffle(List<T> l) {
        return stringRiffle(l, " ");
    }
}
