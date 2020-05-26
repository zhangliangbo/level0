package xxl.mathematica;

import java.math.BigInteger;

/**
 * 位右移
 */

public class BitShiftRight {
    /**
     * 将整数 n 的二进位向右移动 k 个位置，当向右的位置超过个位数位置时，去掉二进制位.
     *
     * @param n
     * @param k
     * @return
     */
    public static int bitShiftRight(int n, int k) {
        return n >> k;
    }

    /**
     * 向右移动一个二进制位.
     *
     * @param n
     * @return
     */
    public static int bitShiftRight(int n) {
        return n >> 1;
    }

    /**
     * 将整数 n 的二进位向右移动 k 个位置，当向右的位置超过个位数位置时，去掉二进制位.
     *
     * @param n
     * @param k
     * @return
     */
    public static long bitShiftRight(long n, int k) {
        return n >> k;
    }

    /**
     * 向右移动一个二进制位.
     *
     * @param n
     * @return
     */
    public static long bitShiftRight(long n) {
        return n >> 1;
    }

    /**
     * 将整数 n 的二进位向右移动 k 个位置，当向右的位置超过个位数位置时，去掉二进制位.
     *
     * @param n
     * @param k
     * @return
     */
    public static BigInteger bitShiftRight(BigInteger n, int k) {
        return n.shiftRight(k);
    }

    /**
     * 向右移动一个二进制位.
     *
     * @param n
     * @return
     */
    public static BigInteger bitShiftRight(BigInteger n) {
        return n.shiftRight(1);
    }
}
