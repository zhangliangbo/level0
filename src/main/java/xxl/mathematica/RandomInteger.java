package xxl.mathematica;

import xxl.mathematica.single.RandomSingle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 伪随机整数
 */

public class RandomInteger {

    private static Random random = RandomSingle.instance();

    /**
     * 伪随机地给出 0 或 1.
     *
     * @return
     */
    public static int randomInteger() {
        return random.nextInt(2);
    }

    /**
     * 给出 {0,max} 范围内的伪随机整数
     *
     * @param max
     * @return
     */
    public static int randomInteger(int max) {
        if (max > 0) {
            return random.nextInt(max);
        } else if (max == 0) {
            return 0;
        } else {
            return -random.nextInt(-max);
        }
    }

    /**
     * 给出 {m,n} 范围内的伪随机整数.
     *
     * @param m
     * @param n
     * @return
     */
    public static int randomInteger(int m, int n) {
        if (m <= n) {
            return randomInteger(n - m) + m;
        } else {
            return randomInteger(m - n) + n;
        }
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
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            result.add(randomInteger(m, n));
        }
        return result;
    }
}
