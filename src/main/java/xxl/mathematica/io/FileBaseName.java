package xxl.mathematica.io;

import io.vavr.control.Option;
import io.vavr.control.Try;
import org.apache.commons.io.FilenameUtils;
import xxl.mathematica.ObjectHelper;

import java.util.concurrent.Callable;

/**
 * 文件基本名
 */

public class FileBaseName {
    /**
     * 给出无扩展名的一个文件的基本名称.
     *
     * @param file
     * @return
     */
    public static String fileBaseName(String file) {
        return Try.ofCallable(() -> FilenameUtils.getBaseName(file)).getOrNull();
    }
}
