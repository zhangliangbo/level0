package xxl.mathematica.io;

import org.apache.commons.logging.LogFactory;

/**
 * 打印日志
 */
public class Log {
  /**
   * 打印日志
   *
   * @param object
   */
  public static void log(Class<?> cls, Object object) {
    LogFactory.getLog(cls).info(object);
  }

  /**
   * 打印日志
   *
   * @param object
   */
  public static void log(Object object) {
    log(Log.class, object);
  }
}
