package xxl.mathematica.io;

import io.vavr.control.Try;
import org.apache.commons.text.StringEscapeUtils;
import xxl.mathematica.list.Take;
import xxl.mathematica.string.StringRiffle;
import xxl.mathematica.string.StringSplit;

import java.io.File;
import java.util.List;

/**
 * 提取文件名
 */
public class FileNameTake {
    /**
     * 获取文件名的一部分
     *
     * @param file
     * @param s
     * @param e
     * @return
     */
    public static String fileNameTake(String file, int s, int e) {
        return Try.ofCallable(() -> {
            List<String> list = StringSplit.stringSplit(file, StringEscapeUtils.escapeJava(File.separator));
            return StringRiffle.stringRiffle(Take.take(list, s, e), File.separator);
        }).getOrNull();
    }

    /**
     * 获取前n个或者后n个
     *
     * @param file
     * @param n
     * @return
     */
    public static String fileNameTake(String file, int n) {
        return Try.ofCallable(() -> {
            List<String> list = StringSplit.stringSplit(file, StringEscapeUtils.escapeJava(File.separator));
            int s = 0;
            int e = list.size();
            if (n < 0) {
                s = list.size() + n;
            } else {
                e = n;
            }
            return StringRiffle.stringRiffle(Take.take(list, s, e), File.separator);
        }).getOrNull();
    }
}
