package xxl.mathematica;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 加
 */

public class Plus {
    /**
     * 表示项的和.
     *
     * @param numbers
     * @return
     */
    public static int plus(Integer... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return 0;
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result += numbers[i];
            }
            return result;
        }
    }

    /**
     * 表示项的和.
     *
     * @param numbers
     * @return
     */
    public static long plus(Long... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return 0L;
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            long result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result += numbers[i];
            }
            return result;
        }
    }


    /**
     * 表示项的和.
     *
     * @param numbers
     * @return
     */
    public static BigInteger plus(BigInteger... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return BigInteger.ZERO;
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            BigInteger result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result.add(numbers[i]);
            }
            return result;
        }
    }

    /**
     * 表示项的和.
     *
     * @param numbers
     * @return
     */
    public static float plus(Float... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return 0F;
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            float result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result += numbers[i];
            }
            return result;
        }
    }

    /**
     * 表示项的和.
     *
     * @param numbers
     * @return
     */
    public static double plus(Double... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return 0D;
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            double result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result += numbers[i];
            }
            return result;
        }
    }


    /**
     * 表示项的和.
     *
     * @param numbers
     * @return
     */
    public static BigDecimal plus(BigDecimal... numbers) {
        ObjectHelper.requireNonNull((Object) numbers);
        if (numbers.length == 0) {
            return BigDecimal.ZERO;
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            BigDecimal result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = result.add(numbers[i]);
            }
            return result;
        }
    }
}
