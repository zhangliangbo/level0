package xxl.mathematica.functional;


import io.vavr.control.Try;
import xxl.mathematica.exception.MaxStepException;

import java.util.concurrent.Callable;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static xxl.mathematica.functional.Constant.MaxStep;

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
    public static <T> T fixPoint(Function<T, T> function, T initValue, BiPredicate<T, T> sameTest) {
        return Try.ofCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                int steps = 0;
                T input = initValue;
                T output = function.apply(input);
                ++steps;

                while (!sameTest.test(input, output)) {
                    input = output;
                    output = function.apply(input);
                    ++steps;
                    if (steps >= MaxStep) {
                        throw new MaxStepException("evaluate times have more the default max times " + MaxStep);
                    }
                }

                return output;
            }
        }).getOrNull();
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回最终结果
     *
     * @param function
     * @param initValue
     * @param precision
     * @return
     */
    public static double fixPoint(Function<Double, Double> function, double initValue, final double precision) {
        return fixPoint(function, initValue, (aDouble, aDouble2) -> Math.abs(aDouble - aDouble2) <= precision);
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回最终结果
     *
     * @param function
     * @param initValue
     * @return
     */
    public static double fixPoint(Function<Double, Double> function, double initValue) {
        return fixPoint(function, initValue, 0D);
    }
}
