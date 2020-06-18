package xxl.mathematica.network;

import io.vavr.control.Try;
import xxl.mathematica.Rule;
import xxl.mathematica.external.External;
import xxl.mathematica.list.Last;
import xxl.mathematica.string.StringCases;

import java.nio.charset.Charset;
import java.util.List;

public class PingTime {
    /**
     * ping时间
     *
     * @return
     */
    public static Long pingTime(String dst) {
        return Try.ofCallable(() -> {
            Rule<Integer, byte[]> rule = External.runProcess("ping " + dst);
            if (rule.getKey() == 0) {
                String res = new String(rule.getValue(), Charset.forName("GBK"));
                return Long.valueOf(Last.last(StringCases.stringCases(res, "= (\\d*)ms", 1)));
            } else {
                return null;
            }
        }).getOrNull();
    }

    /**
     * 一次性ping多次
     *
     * @param dst
     * @param times
     * @return
     */
    public static List<Long> pingTime(String dst, long times) {
        return io.vavr.collection.List.range(0, times)
                .map(aLong -> pingTime(dst))
                .asJava();
    }
}
