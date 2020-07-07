package xxl.mathematica.io;

import io.vavr.control.Try;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/**
 * 复制文件
 */
public class CopyFile {
  /**
   * 复制文件
   *
   * @param src
   * @param dst
   * @return
   */
  public static String copyFile(String src, String dst, boolean overwrite) {
    return Try.ofCallable(() -> {
      String parentDirectory = ParentDirectory.parentDirectory(dst);
      File parent=new File(parentDirectory);
      if (!parent.exists()&&!parent.mkdirs()) {
        return null;
      }
      if (FileExistsQ.fileExistsQ(dst) && !overwrite) {
        return null;
      }
      int len = IOUtils.copy(new FileInputStream(src), new FileOutputStream(dst));
      if (len == -1) {
        return null;
      }
      return dst;
    }).getOrNull();
  }

  /**
   * 默认存在时覆盖
   *
   * @param src
   * @param dst
   * @return
   */
  public static String copyFile(String src, String dst) {
    return copyFile(src, dst, true);
  }
}