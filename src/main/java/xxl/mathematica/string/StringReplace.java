package xxl.mathematica.string;

import io.vavr.control.Try;
import xxl.mathematica.Rule;

import java.util.concurrent.Callable;

/**
 * 字符串替换
 */
public class StringReplace {
  /**
   * 字符串替换
   *
   * @param src
   * @param r
   * @return
   */
  public static String stringReplace(String src, Rule<String, String> r) {
    return Try.ofCallable(() -> src.replaceAll(r.getKey(), r.getValue())).getOrNull();
  }
}
