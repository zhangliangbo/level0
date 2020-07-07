package xxl.mathematica.io;

import java.io.File;

/**
 * 文件是否存在
 */
public class FileExistsQ {
    /**
     * 文件是否存在
     *
     * @return
     */
    public static boolean fileExistsQ(String file) {
        return new File(file).exists();
    }
}
