package xxl.mathematica.string;

import xxl.mathematica.ObjectHelper;
import xxl.mathematica.function.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串匹配
 */
public class StringCases {
    /**
     * 给出匹配的子字符串列表
     *
     * @param source
     * @param regex
     * @return
     */
    public static List<String> stringCases(String source, String regex) {
        return stringCases(source, regex, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        });
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
    public static <R> List<R> stringCases(String source, String regex, Function<String, R> f) {
        ObjectHelper.requireNonNull(source, regex, f);
        Matcher matcher = Pattern.compile(regex).matcher(source);
        List<R> sub = new ArrayList<>();
        while (matcher.find()) {
            sub.add(f.apply(matcher.group()));
        }
        return sub;
    }
}
