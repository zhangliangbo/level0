package xxl.mathematica;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * 伪随机整数
 */

public class RandomInteger {

  /**
   * 伪随机地给出 0 或 1.
   *
   * @return
   */
  public static int randomInteger() {
    return randomInteger(2);
  }

  /**
   * 给出 {0,max} 范围内的伪随机整数
   *
   * @param max
   * @return
   */
  public static int randomInteger(int max) {
    return RandomUtils.nextInt(0, max);
  }

  /**
   * 给出 {m,n} 范围内的伪随机整数.
   *
   * @param m
   * @param n
   * @return
   */
  public static int randomInteger(int m, int n) {
    return m + randomInteger(n - m);
  }

  /**
   * 给出num个 {m,n} 范围内的伪随机整数.
   *
   * @param m   包含
   * @param n   不包含
   * @param num
   * @return
   */
  public static List<Integer> randomInteger(int m, int n, int num) {
    return io.vavr.collection.List.range(0, num)
        .map(integer -> randomInteger(m, n))
        .asJava();
  }
}
