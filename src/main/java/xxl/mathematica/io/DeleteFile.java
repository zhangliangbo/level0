package xxl.mathematica.io;

import io.vavr.control.Try;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * 删除文件
 */
public class DeleteFile {
    /**
     * 删除文件
     *
     * @param file
     * @return
     */
    public static boolean deleteFile(String file) {
        return deleteFile(Collections.singletonList(file));
    }

    /**
     * 删除
     *
     * @param files
     * @return
     */
    public static boolean deleteFile(List<String> files) {
        return Try.ofCallable(() -> {
            for (String s : files) {
                if (!FileUtils.deleteQuietly(new File(s))) {
                    return false;
                }
            }
            return true;
        }).getOrElse(false);
    }
}
