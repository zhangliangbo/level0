package xxl.mathematica.time;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.TimeZone;

/**
 * 日期字符串
 */
public class DateString {
    /**
     * 日期字符串
     * TimeZone.getTimeZone("GMT+8")
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateString(Date date, String format) {
        return DateFormatUtils.format(date, format, TimeZone.getTimeZone("GMT+8"));
    }

    /**
     * 默认yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String dateString(Date date) {
        return dateString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化当前时间
     *
     * @param format
     * @return
     */
    public static String dateString(String format) {
        return dateString(new Date(), format);
    }

    /**
     * 当前时间的字符串
     *
     * @return
     */
    public static String dateString() {
        return dateString(new Date(System.currentTimeMillis()));
    }
}
