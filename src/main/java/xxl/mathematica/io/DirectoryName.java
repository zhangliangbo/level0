package xxl.mathematica.io;

import io.vavr.control.Try;
import xxl.mathematica.functional.Nest;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 目录名称
 */

public class DirectoryName {
    /**
     * 应用 n 次
     *
     * @param file
     * @param n
     * @return
     */
    public static String directoryName(String file, int n) {
        return Try.ofCallable(() -> {
            return Nest.nest(t -> t == null ? null : t.getParentFile(), new File(file), n).getAbsolutePath();//取绝对路径
        }).getOrNull();
    }

    /**
     * 从指定的文件中提取目录名称.
     *
     * @param file
     * @return
     */
    public static String directoryName(String file) {
        return directoryName(file, 1);
    }
}
