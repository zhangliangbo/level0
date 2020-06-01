package xxl.mathematica.string;

import io.vavr.control.Option;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * 字符串包容判定
 */
public class StringContainsQ {
    /**
     * 包含判定的算子
     *
     * @param regex
     * @return
     */
    public static Function<String, Boolean> stringContainQ(String regex) {
        return new Function<String, Boolean>() {
            final Pattern pattern = Pattern.compile(regex);

            @Override
            public Boolean apply(String s) {
                return pattern.matcher(s).matches();
            }
        };
    }

    /**
     * 字符串包容判定
     *
     * @param source
     * @param regex
     * @return
     */
    public static boolean stringContainsQ(String source, String regex) {
        return Option.of(Pattern.compile(regex).matcher(source).matches()).getOrNull();
    }
}
