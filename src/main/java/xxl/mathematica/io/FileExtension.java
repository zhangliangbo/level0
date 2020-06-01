package xxl.mathematica.io;

import io.vavr.control.Option;
import io.vavr.control.Try;
import org.apache.commons.io.FilenameUtils;
import xxl.mathematica.ObjectHelper;

import java.util.concurrent.Callable;

/**
 * 文件扩展名
 */

public class FileExtension {
    /**
     * 给出一个文件的扩展名.
     *
     * @param file
     * @return
     */
    public static String fileExtension(String file) {
        return Try.ofCallable(() -> FilenameUtils.getExtension(file)).getOrNull();
    }
}
