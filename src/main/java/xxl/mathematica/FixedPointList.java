package xxl.mathematica;

import xxl.mathematica.exception.MaxStepException;
import xxl.mathematica.function.BiPredicate;
import xxl.mathematica.function.Function;

import java.util.ArrayList;
import java.util.List;

import static xxl.mathematica.Constant.MaxStep;

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
    public static <T> List<T> fixPointList(Function<T, T> function, T initValue, BiPredicate<T, T> sameTest) throws MaxStepException {
        ObjectHelper.requireNonNull(function, initValue, sameTest);

        List<T> result = new ArrayList<T>(1);
        int steps = 0;

        result.add(initValue);//加入最开始的值

        T input = initValue;
        T output = function.apply(input);
        result.add(output);//加入第一个结果
        steps++;

        while (!sameTest.test(input, output)) {
            input = output;
            output = function.apply(input);
            steps++;
            result.add(output);//加入后续结果
            if (steps >= MaxStep) {//超过最大步数，抛出异常
                throw new MaxStepException("evaluate times have more the default max times " + MaxStep);
            }
        }
        return result;
    }

    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回计算过程产生的过程值列表
     *
     * @param function
     * @param initValue
     * @param sameTest
     * @param maxStepNum
     * @param <T>
     * @return
     * @throws MaxStepException
     */
    public static <T> List<T> fixPointList(Function<T, T> function, T initValue, BiPredicate<T, T> sameTest, int maxStepNum) {
        ObjectHelper.requireNonNull(function, initValue, sameTest);
        ObjectHelper.requirePositive(maxStepNum);

        List<T> result = new ArrayList<T>(maxStepNum + 1);
        int steps = 0;

        result.add(initValue);//加入最开始的值

        T input = initValue;
        T output = function.apply(input);
        result.add(output);//加入第一个结果
        steps++;

        while (!sameTest.test(input, output)) {
            if (steps >= maxStepNum) {//超过最大步数，跳出循环，直接返回结果
                break;
            }
            input = output;
            output = function.apply(input);
            result.add(output);//加入后续结果
            steps++;
        }
        return result;
    }


    /**
     * 将函数function作用于初始值initValue，直到sameTest满足为止，并返回计算过程产生的过程值列表
     *
     * @param function
     * @param initValue
     * @return
     */
    public static List<Double> fixPointList(Function<Double, Double> function, Double initValue, final double precision) throws MaxStepException {
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
    public static List<Double> fixPointList(Function<Double, Double> function, Double initValue) throws MaxStepException {
        return fixPointList(function, initValue, new BiPredicate<Double, Double>() {
            @Override
            public boolean test(Double a, Double b) {
                return a.doubleValue() == b.doubleValue();
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
    public static List<Double> fixPointList(Function<Double, Double> function, Double initValue, final double precision, int maxStepNum) {
        return fixPointList(function, initValue, new BiPredicate<Double, Double>() {
            @Override
            public boolean test(Double a, Double b) {
                return Math.abs(a - b) <= precision;
            }
        }, maxStepNum);
    }
}
