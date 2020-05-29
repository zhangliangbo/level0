package xxl.mathematica.io;

import xxl.mathematica.ObjectHelper;

import java.io.File;

/**
 * 创建压缩文件
 */
public class CreateArchive {
    /**
     * 创建压缩文件
     *
     * @param source                        源文件或目录
     * @param path                          目标文件或目录
     * @param createIntermediateDirectories 是否创建中间目录
     * @return
     */
    public static String CreateArchive(String source, String path, boolean createIntermediateDirectories) {
        ObjectHelper.requireNonNull(source, path);
        File dst = new File(path);
        if (dst.isDirectory()) {

        }
        File src = new File(source);

        if (src.isFile()) {

        } else {

        }
        return null;
    }
}
