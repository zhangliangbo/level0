package xxl.mathematica.time;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 日期列表
 */
public class DateList {
  /**
   * 日期字符串转成日期
   *
   * @param dateString
   * @param format
   * @return
   */
  public static Date dateList(String dateString, String format) {
    try {
      return DateUtils.parseDate(dateString, format);
    } catch (ParseException e) {
      return null;
    }
  }

  /**
   * 默认格式：yyyy-MM-dd HH:mm:ss
   *
   * @param dateString
   * @return
   */
  public static Date dateList(String dateString) {
    return dateList(dateString, "yyyy-MM-dd HH:mm:ss");
  }
}
