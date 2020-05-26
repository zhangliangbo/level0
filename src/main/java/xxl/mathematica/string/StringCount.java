package xxl.mathematica.string;

import xxl.mathematica.ObjectHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串计数
 */
public class StringCount {
  /**
   * 字符串计数
   *
   * @param source
   * @param regex
   * @return
   */
  public static int stringCount(String source, String regex) {
    ObjectHelper.requireNonNull(source, regex);
    Matcher matcher = Pattern.compile(regex).matcher(source);
    int count = 0;
    while (matcher.find()) {
      ++count;
    }
    return count;
  }
}
