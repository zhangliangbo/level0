package xxl.mathematica;

import java.io.File;

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
        ObjectHelper.requireNonNull(dir);
        File file = new File(dir);
        if (file.exists()) {
            if (file.isDirectory()) {
                String parent = file.getParent();
                return parent == null ? "" : parent;
            } else {
                throw new IllegalArgumentException("dir is not a directory");
            }
        } else {
            throw new IllegalArgumentException("dir does not exist");
        }
    }
}
