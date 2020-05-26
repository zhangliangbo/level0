package xxl.mathematica.functional;


import java.util.List;
import java.util.function.Function;

/**
 * 应用
 */

public class Apply {
  /**
   * 应用函数到列表中
   *
   * @param function
   * @param list
   * @param <T>
   * @param <R>
   * @return
   */
  public static <T, R> R apply(Function<List<T>, R> function, List<T> list) {
    return io.vavr.collection.List.of(list)
        .map(function)
        .get();
  }
}
