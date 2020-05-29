package xxl.mathematica;

import org.apache.commons.io.FilenameUtils;

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
        ObjectHelper.requireNonNull(file);
        return FilenameUtils.getExtension(file);
    }
}
