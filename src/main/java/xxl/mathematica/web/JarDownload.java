package xxl.mathematica.web;

import io.vavr.control.Try;
import xxl.mathematica.Rule;
import xxl.mathematica.cryptology.Hash;
import xxl.mathematica.io.CopyFile;
import xxl.mathematica.io.DeleteFile;
import xxl.mathematica.io.ParentDirectory;
import xxl.mathematica.logic.AllTrue;
import xxl.mathematica.string.StringReplace;
import xxl.mathematica.string.StringSplit;

import java.io.File;
import java.util.Arrays;
import java.util.List;
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
    return Try.ofCallable(() -> {
      List<String> coordinates = StringSplit.stringSplit(coordinate, ":");
      String group = coordinates.get(0);
      String artifact = coordinates.get(1);
      String version = coordinates.get(2);
      String base = maven + StringReplace.stringReplace(group, Rule.valueOf("\\.", "/")) + "/" + artifact + "/" + version + "/";
      String fileName = artifact + "-" + version;
      String tDir = dir + File.separator + StringReplace.stringReplace(group, Rule.valueOf("\\.", File.separator)) + File.separator + artifact + File.separator + version + File.separator;
      String[] files = new String[]{fileName + ".jar", fileName + "-sources.jar", fileName + ".pom"};
      String[] copies = new String[files.length];
      for (int i = 0; i < files.length; i++) {
        String file = files[i];
        int max = 10;//最多尝试10次
        while (max-- >= 0) {
          String url = base + file;
          System.err.println(url);
          String res = URLDownload.urlDownload(url, tDir, aFloat -> f.accept(file, aFloat));
          if (res == null) {
            System.out.println(max);
            Thread.sleep(1000);
          } else {
            String sha1 = Hash.encodeHexString(Hash.hashFile(res, Hash.Algorithm.SHA1));
            String parent = ParentDirectory.parentDirectory(res);
            copies[i] = CopyFile.copyFile(res, parent + File.separator + sha1 +File.separator+ file);
            if(!DeleteFile.deleteFile(res)){
              copies[i]=null;
            }
            break;
          }
        }
      }
      if (AllTrue.allTrue(Arrays.asList(copies), s -> s != null)) {
        return tDir;
      } else {
        return null;
      }
    }).getOrNull();
  }
}
