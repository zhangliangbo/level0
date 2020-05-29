package xxl.mathematica;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 最大值
 */

public class Max {
    /**
     * 给出 Subscript[x, i] 中的数值最大者.
     *
     * @param numbers
     * @return
     */
    public static int max(Integer... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Integer.MIN_VALUE;
        } else {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? numbers[i] : result;
            }
            return result;
        }
    }

    /**
     * 给出 Subscript[x, i] 中的数值最大者.
     *
     * @param numbers
     * @return
     */
    public static long max(Long... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Long.MIN_VALUE;
        } else {
            long result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? numbers[i] : result;
            }
            return result;
        }
    }

    /**
     * 给出 Subscript[x, i] 中的数值最大者.
     *
     * @param numbers
     * @return
     */
    public static BigInteger max(BigInteger... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {//理论上BigInteger是没有最小值的，所有使用Long类型的最小值
            return BigInteger.valueOf(Long.MIN_VALUE);
        } else {
            BigInteger result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result.max(numbers[i]);
            }
            return result;
        }
    }

    /**
     * 给出 Subscript[x, i] 中的数值最大者.
     *
     * @param numbers
     * @return
     */
    public static float max(Float... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Float.MIN_VALUE;
        } else {
            float result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? numbers[i] : result;
            }
            return result;
        }
    }

    /**
     * 给出 Subscript[x, i] 中的数值最大者.
     *
     * @param numbers
     * @return
     */
    public static double max(Double... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Double.MIN_VALUE;
        } else {
            double result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? numbers[i] : result;
            }
            return result;
        }
    }

    /**
     * 给出 Subscript[x, i] 中的数值最大者.
     *
     * @param numbers
     * @return
     */
    public static BigDecimal max(BigDecimal... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return BigDecimal.valueOf(Double.MIN_VALUE);
        } else {
            BigDecimal result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result.max(numbers[i]);
            }
            return result;
        }
    }
}
