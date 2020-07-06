package xxl.mathematica.io;

import io.vavr.control.Try;

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
  public static String copyFile(String src, String dst) {
    return Try.ofCallable((Callable<String>) () -> null).getOrNull();
  }
}
