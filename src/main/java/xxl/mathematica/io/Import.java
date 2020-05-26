package xxl.mathematica.io;

import com.google.gson.reflect.TypeToken;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import xxl.mathematica.io.excel.AbsExcel;
import xxl.mathematica.io.excel.IExcel;
import xxl.mathematica.single.GsonSingle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * 导入
 */
public class Import {
  /**
   * 默认jxl，支持android
   *
   * @param file
   * @return
   */
  public static List<List<String[]>> importExcel(String file) {
    return importExcel(IExcel.JXL, file);
  }

  /**
   * 导入excel为字符串
   *
   * @param method
   * @param file
   * @return
   */
  public static List<List<String[]>> importExcel(int method, String file) {
    try {
      return AbsExcel.getExcelImpl(method).importExcel(file);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * 默认jxl，支持android
   *
   * @param file
   * @return
   */
  public static <T> List<List<T>> importExcel(String file, Class<T> cls) {
    return importExcel(IExcel.JXL, file, cls);
  }

  /**
   * 导入excel为对象
   *
   * @param method
   * @param file
   * @return
   */
  public static <T> List<List<T>> importExcel(int method, String file, Class<T> cls) {
    try {
      return AbsExcel.getExcelImpl(method).importExcel(file, cls);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * 以Json的格式导入为对象
   * UTF-8
   *
   * @param file
   * @return
   */
  public static Map<String, Object> importJson(String file) {
    try {
      return GsonSingle.instance().fromJson(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8), new TypeToken<Map<String, Object>>() {
      }.getType());
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  /**
   * 以Json的格式导入为字符串
   * UTF-8
   *
   * @param file
   * @return
   */
  public static Map<String, String> importJsonAsString(String file) {
    try {
      return GsonSingle.instance().fromJson(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8), new TypeToken<Map<String, String>>() {
      }.getType());
    } catch (FileNotFoundException e) {
      return null;
    }
  }


  /**
   * 以文本形式导入
   *
   * @param file
   * @return
   */
  public static String importText(String file) {
    try (FileInputStream fis = new FileInputStream(file)) {
      return IOUtils.toString(fis, Charsets.UTF_8);
    } catch (IOException e) {
      return null;
    }
  }
}
