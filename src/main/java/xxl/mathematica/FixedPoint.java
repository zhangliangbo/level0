package xxl.mathematica;


import xxl.mathematica.exception.MaxStepException;
import xxl.mathematica.function.BiPredicate;
import xxl.mathematica.function.Function;

import static xxl.mathematica.Constant.MaxStep;

/**
 * 用 initValue 开始，然后重复应用 function 直到结果不再改变.
 */
public class FixedPoint {

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回最终结果
     *
     * @param function
     * @param initValue 初始值
     * @param sameTest  两个相邻结果的等价判断
     * @param <T>
     * @return
     */
    public static <T> T fixPoint(Function<T, T> function, T initValue, BiPredicate<T, T> sameTest) throws MaxStepException {
        ObjectHelper.requireNonNull(function, initValue, sameTest);

        int steps = 0;

        T input = initValue;
        T output = function.apply(input);
        steps++;
        while (!sameTest.test(input, output)) {
            input = output;
            output = function.apply(input);
            steps++;
            if (steps >= MaxStep) {
                throw new MaxStepException("evaluate times have more the default max times " + MaxStep);
            }
        }
        return output;
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回最终结果
     *
     * @param function
     * @param initValue  初始值
     * @param sameTest   两个相邻结果的等价判断
     * @param maxStepNum 最大计算步数（默认是65535）
     * @param <T>
     * @return
     */
    public static <T> T fixPoint(Function<T, T> function, T initValue, BiPredicate<T, T> sameTest, int maxStepNum) {
        ObjectHelper.requireNonNull(function, initValue, sameTest);
        ObjectHelper.requirePositive(maxStepNum);

        int steps = 0;

        T input = initValue;
        T output = function.apply(input);
        steps++;
        while (!sameTest.test(input, output)) {
            if (steps >= maxStepNum) {//超过最大步数，直接跳出循环，返回结果
                break;
            }
            input = output;
            output = function.apply(input);
            steps++;
        }
        return output;
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回最终结果
     *
     * @param function
     * @param initValue
     * @param precision
     * @return
     * @throws MaxStepException
     */
    public static double fixPoint(Function<Double, Double> function, double initValue, final double precision) throws MaxStepException {
        return fixPoint(function, initValue, new BiPredicate<Double, Double>() {
            @Override
            public boolean test(Double aDouble, Double aDouble2) {
                return Math.abs(aDouble - aDouble2) <= precision;
            }
        });
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回最终结果
     *
     * @param function
     * @param initValue
     * @param precision
     * @return
     * @throws MaxStepException
     */
    public static double fixPoint(Function<Double, Double> function, double initValue, final double precision, int maxStepNum) {
        return fixPoint(function, initValue, new BiPredicate<Double, Double>() {
            @Override
            public boolean test(Double aDouble, Double aDouble2) {
                return Math.abs(aDouble - aDouble2) <= precision;
            }
        }, maxStepNum);
    }
}
