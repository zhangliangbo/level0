package xxl.mathematica;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 最小值
 */

public class Min {
    /**
     * 用来给出 Subscript[x, i] 的数值最小值.
     *
     * @param numbers
     * @return
     */
    public static int min(Integer... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Integer.MAX_VALUE;
        } else {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? result : numbers[i];
            }
            return result;
        }
    }

    /**
     * 用来给出 Subscript[x, i] 的数值最小值.
     *
     * @param numbers
     * @return
     */
    public static Long min(Long... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Long.MAX_VALUE;
        } else {
            long result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? result : numbers[i];
            }
            return result;
        }
    }

    /**
     * 用来给出 Subscript[x, i] 的数值最小值.
     *
     * @param numbers
     * @return
     */
    public static BigInteger min(BigInteger... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return BigInteger.valueOf(Long.MAX_VALUE);
        } else {
            BigInteger result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result.min(numbers[i]);
            }
            return result;
        }
    }

    /**
     * 用来给出 Subscript[x, i] 的数值最小值.
     *
     * @param numbers
     * @return
     */
    public static float min(Float... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Float.MAX_VALUE;
        } else {
            float result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? result : numbers[i];
            }
            return result;
        }
    }

    /**
     * 用来给出 Subscript[x, i] 的数值最小值.
     *
     * @param numbers
     * @return
     */
    public static double min(Double... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result < numbers[i] ? result : numbers[i];
            }
            return result;
        }
    }

    /**
     * 用来给出 Subscript[x, i] 的数值最小值.
     *
     * @param numbers
     * @return
     */
    public static BigDecimal min(BigDecimal... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return BigDecimal.valueOf(Double.MAX_VALUE);
        } else {
            BigDecimal result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result.min(numbers[i]);
            }
            return result;
        }
    }
}
