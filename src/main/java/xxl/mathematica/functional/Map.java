package xxl.mathematica.functional;

import java.util.List;
import java.util.function.Function;

/**
 * 映射
 */

public class Map {
  /**
   * 将 f 应用到 list 的每个元素.
   *
   * @param function
   * @param list
   * @param <T>
   * @return
   */
  public static <T, R> List<R> map(Function<T, R> function, List<T> list) {
    return io.vavr.collection.List.ofAll(list)
        .map(function)
        .asJava();
  }
}
