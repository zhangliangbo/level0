package xxl.mathematica;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import xxl.mathematica.functional.Map;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 文件名称
 */
public class FileNames {
    /**
     * 查找文件
     *
     * @param regex
     * @param dir
     * @param recursive 是否递归
     * @return
     */
    public static List<String> fileNames(String regex, String dir, boolean recursive) {
        ObjectHelper.requireNonNull(regex, dir);
        File directory = new File(dir);
        if (directory.isDirectory()) {
            Collection<File> files = FileUtils.listFiles(directory, new RegexFileFilter(regex), recursive ? TrueFileFilter.TRUE : null);
            return Map.map(File::getAbsolutePath, new ArrayList<>(files));
        } else {
            return Arrays.asList(directory.getAbsolutePath());
        }
    }

    /**
     * 默认递归
     *
     * @param regex
     * @param dir
     * @return
     */
    public static List<String> fileNames(String regex, String dir) {
        return fileNames(regex, dir, true);
    }

}
