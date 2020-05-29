package xxl.mathematica;

import java.math.BigInteger;

/**
 * 位左移
 */

public class BitShiftLeft {
    /**
     * 向左移动整数 n 的二进位 k 个位置，在右边填充 0.
     *
     * @param n
     * @param k
     * @return
     */
    public static int bitShiftLeft(int n, int k) {
        return n << k;
    }

    /**
     * 向左移动一个二进制位.
     *
     * @param n
     * @return
     */
    public static int bitShiftLeft(int n) {
        return n << 1;
    }

    /**
     * 向左移动整数 n 的二进位 k 个位置，在右边填充 0.
     *
     * @param n
     * @param k
     * @return
     */
    public static long bitShiftLeft(long n, int k) {
        return n << k;
    }

    /**
     * 向左移动一个二进制位.
     *
     * @param n
     * @return
     */
    public static long bitShiftLeft(long n) {
        return n << 1;
    }

    /**
     * 向左移动整数 n 的二进位 k 个位置，在右边填充 0.
     *
     * @param n
     * @param k
     * @return
     */
    public static BigInteger bitShiftLeft(BigInteger n, int k) {
        return n.shiftLeft(k);
    }

    /**
     * 向左移动一个二进制位.
     *
     * @param n
     * @return
     */
    public static BigInteger bitShiftLeft(BigInteger n) {
        return n.shiftLeft(1);
    }
}
