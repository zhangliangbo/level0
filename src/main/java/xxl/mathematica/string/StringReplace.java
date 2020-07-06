package xxl.mathematica.string;

import io.vavr.control.Try;
import org.apache.commons.text.StringEscapeUtils;
import xxl.mathematica.Rule;

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
    return Try.ofCallable(() -> src.replaceAll(r.getKey(), StringEscapeUtils.escapeJava(r.getValue()))).getOrNull();
  }
}
