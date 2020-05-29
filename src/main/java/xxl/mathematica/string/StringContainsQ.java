package xxl.mathematica.string;

import xxl.mathematica.ObjectHelper;

import java.util.function.Function;
import java.util.regex.Matcher;
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
        ObjectHelper.requireNonNull(source, regex);
        Matcher matcher = Pattern.compile(regex).matcher(source);
        return matcher.matches();
    }
}
