package xxl.mathematica.io;

/**
 * 父目录
 */

public class ParentDirectory {

    /**
     * 给出目录 dir 的父目录.
     *
     * @param dir 必须存在且为目录
     * @return
     */
    public static String parentDirectory(String dir) {
        return DirectoryName.directoryName(dir);
    }
}
