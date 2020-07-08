package xxl.mathematica.network;

import io.vavr.control.Try;
import xxl.mathematica.Rule;
import xxl.mathematica.external.External;
import xxl.mathematica.list.Last;
import xxl.mathematica.string.StringCases;
import xxl.mathematica.system.Os;

import java.nio.charset.Charset;
import java.util.List;

public class PingTime {
    /**
     * ping时间
     *
     * @return
     */
    public static Double pingTime(String dst) {
        return Try.ofCallable(() -> {
            if (Os.isWindows()) {
                Rule<Integer, byte[]> rule = External.runProcess("ping " + dst);
                if (rule.getKey() == 0) {
                    String res = new String(rule.getValue(), Charset.forName("GBK"));
                    return Double.valueOf(Last.last(StringCases.stringCases(res, "= (\\d*)ms", 1)));
                } else {
                    return null;
                }
            } else if (Os.isLinux()) {
                Rule<Integer, byte[]> rule = External.runProcess("ping -c 10" + dst);
                if (rule.getKey() == 0) {
                    String res = new String(rule.getValue(), Charset.forName("GBK"));
                    return Double.valueOf(Last.last(StringCases.stringCases(res, "= .*/(.*)/.*/.* ms", 1)));
                } else {
                    return null;
                }
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
    public static List<Double> pingTime(String dst, long times) {
        return io.vavr.collection.List.range(0, times)
                .map(aLong -> pingTime(dst))
                .asJava();
    }

    public static void main(String[] args) {
        String url = "www.baidu.com";
        if (args.length > 0) {
            url = args[0];
        }
        System.out.println(PingTime.pingTime(url));
    }
}
