package xxl.mathematica.web;

import io.vavr.control.Try;
import xxl.mathematica.Rule;
import xxl.mathematica.cryptology.Hash;
import xxl.mathematica.io.CopyFile;
import xxl.mathematica.io.ParentDirectory;
import xxl.mathematica.string.StringReplace;
import xxl.mathematica.string.StringSplit;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;

/**
 * 下载jar
 */
public class JarDownload {
  static final String maven = "https://repo1.maven.org/maven2/";

  /**
   * 下载jar文件，三个文件
   * .jar
   * .-sources.jar
   * .pom
   *
   * @param coordinate 类似 io.netty:netty-all:4.1.49.Final
   * @param dir
   * @param f
   */
  public static String jarDownload(String coordinate, String dir, BiConsumer<String, Float> f) {
    return Try.ofCallable((Callable<String>) () -> {
      List<String> coordinates = StringSplit.stringSplit(coordinate, ":");
      String group = coordinates.get(0);
      String artifact = coordinates.get(1);
      String version = coordinates.get(2);
      String base = maven + StringReplace.stringReplace(group, Rule.valueOf("\\.", "/")) + "/" + artifact + "/" + version + "/";
      String fileName = artifact + "-" + version;
      String[] files = new String[]{fileName + ".jar", fileName + "-sources.jar", fileName + ".pom"};
      for (String file : files) {
        int i = 10;//最多尝试10次
        while (i-- >= 0) {
          String res = URLDownload.urlDownload(base + file, dir, aFloat -> f.accept(file, aFloat));
          if (res == null) {
            System.out.println(i);
            Thread.sleep(1000);
          } else {
            String sha1 = Hash.encodeHexString(Hash.hashFile(res, Hash.Algorithm.SHA1));
            CopyFile.copyFile()
            break;
          }
        }
      }
      return null;
    }).getOrNull();
  }
}
