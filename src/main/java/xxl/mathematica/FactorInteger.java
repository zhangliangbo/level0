package xxl.mathematica;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数因式分解
 */
public class FactorInteger {
    /**
     * 因式分解
     *
     * @param number
     * @return
     */
    public static List<Long> factorInteger(long number) {
        List<Long> factors = new ArrayList<>();
        while (true) {
            long factor = number;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    factor = i;
                    break;
                }
            }
            factors.add(factor);
            if (number == factor) {
                break;
            }
            number = number / factor;
        }
        return factors;
    }
}
