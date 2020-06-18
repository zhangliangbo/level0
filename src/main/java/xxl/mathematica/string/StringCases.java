package xxl.mathematica.string;

import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串匹配
 */
public class StringCases {
    /**
     * 默认组0
     *
     * @param source
     * @param regex
     * @return
     */
    public static List<String> stringCases(String source, String regex) {
        return stringCases(source, regex, 0);
    }


    /**
     * 给出匹配的子字符串列表
     *
     * @param source
     * @param regex
     * @return
     */
    public static List<String> stringCases(String source, String regex, int group) {
        return stringCases(source, regex, group, s -> s);
    }

    /**
     * 默认组0，代表整个表达式
     *
     * @param source
     * @param regex
     * @param f
     * @param <R>
     * @return
     */
    public static <R> List<R> stringCases(String source, String regex, Function<String, R> f) {
        return stringCases(source, regex, 0, f);
    }

    /**
     * 给出匹配的子字符串列表，并转换
     *
     * @param source
     * @param regex
     * @param f
     * @param <R>
     * @return
     */
    public static <R> List<R> stringCases(String source, String regex, int group, Function<String, R> f) {
        return Try.ofCallable(() -> {
            Matcher matcher = Pattern.compile(regex).matcher(source);
            List<R> sub = new ArrayList<>();
            while (matcher.find()) {
                sub.add(f.apply(matcher.group(group)));
            }
            return sub;
        }).getOrNull();
    }
}
