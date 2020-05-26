package xxl.mathematica.functional;


import java.util.List;
import java.util.function.Consumer;

/**
 * 扫描
 */
public class Scan {
  /**
   * 将函数作用到每个元素
   *
   * @param f
   * @param list
   * @param <T>
   */
  public static <T> void scan(Consumer<T> f, List<T> list) {
    io.vavr.collection.List.ofAll(list)
        .forEach(f);
  }
}
