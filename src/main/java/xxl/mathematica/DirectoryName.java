package xxl.mathematica;

import xxl.mathematica.functional.Nest;

import java.io.File;
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
        ObjectHelper.requireNonNull(file);
        ObjectHelper.requirePositive(n);
        File result = Nest.nest(new Function<File, File>() {
            @Override
            public File apply(File file) {
                return file == null ? null : file.getParentFile();
            }
        }, new File(file), n);
        return result == null ? null : result.getAbsolutePath();//取绝对路径
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
