package xxl.mathematica.time;

import io.vavr.control.Try;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.Callable;

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
        return Try.ofCallable(() -> DateUtils.parseDate(dateString, format)).getOrNull();
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
