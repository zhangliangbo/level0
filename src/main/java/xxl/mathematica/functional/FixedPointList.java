package xxl.mathematica.functional;

import io.vavr.control.Try;
import xxl.mathematica.exception.MaxStepException;
import xxl.mathematica.function.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiPredicate;

import static xxl.mathematica.functional.Constant.MaxStep;

/**
 * Created by zhang on 2017/9/1.
 */

public class FixedPointList {

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回计算过程产生的过程值列表
     *
     * @param function
     * @param initValue
     * @param sameTest
     * @param <T>
     * @return
     */
    public static <T> List<T> fixPointList(Function<T, T> function, T initValue, BiPredicate<T, T> sameTest) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> result = new ArrayList<T>(1);
                int steps = 0;

                result.add(initValue);//加入最开始的值

                T input = initValue;
                T output = function.apply(input);
                result.add(output);//加入第一个结果
                ++steps;

                while (!sameTest.test(input, output)) {
                    input = output;
                    output = function.apply(input);
                    ++steps;
                    result.add(output);//加入后续结果
                    if (steps >= MaxStep) {//超过最大步数，抛出异常
                        throw new MaxStepException("evaluate times have more the default max times " + MaxStep);
                    }
                }
                return result;
            }
        }).getOrNull();
    }


    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回计算过程产生的过程值列表
     *
     * @param function
     * @param initValue
     * @return
     */
    public static List<Double> fixPointList(Function<Double, Double> function, Double initValue, final double precision) {
        return fixPointList(function, initValue, new BiPredicate<Double, Double>() {
            @Override
            public boolean test(Double a, Double b) {
                return Math.abs(a - b) <= precision;
            }
        });
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回计算过程产生的过程值列表
     *
     * @param function
     * @param initValue
     * @return
     */
    public static List<Double> fixPointList(Function<Double, Double> function, Double initValue) {
        return fixPointList(function, initValue, 0D);
    }

}
