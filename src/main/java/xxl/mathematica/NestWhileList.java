package xxl.mathematica;

import xxl.mathematica.exception.MaxStepException;
import xxl.mathematica.exception.NoEnoughResultException;
import xxl.mathematica.function.BiPredicate;
import xxl.mathematica.function.Function;
import xxl.mathematica.function.Predicate;

import java.util.ArrayList;
import java.util.List;

import static xxl.mathematica.Constant.MaxStep;

/**
 * 嵌套列表循环
 */

public class NestWhileList {
    /**
     * 从 initValue 开始，然后重复应用 function 直到 test 不再得到 True 为止，并返回中间结果列表
     *
     * @param function
     * @param initValue
     * @param test
     * @param <T>
     * @return
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, Predicate<T> test) throws MaxStepException {
        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");

        List<T> result = new ArrayList<T>(0);
        T input = initValue;
        result.add(input);
        int steps = 0;
        while (test.test(input)) {
            T output = function.apply(input);
            steps++;
            result.add(output);
            input = output;
            if (steps >= MaxStep) {
                throw new MaxStepException(MaxStep);//达到最大迭代次数，直接抛出异常
            }
        }
        return result;
    }

    /**
     * @param function
     * @param initValue
     * @param test      最后两个结果作为判定的参数
     * @param <T>
     * @return
     * @throws MaxStepException
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, BiPredicate<T, T> test) throws MaxStepException {
        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");

        List<T> result = new ArrayList<T>(0);//最终的结果列表
        int steps = 0;
        T temp1 = initValue;
        result.add(temp1);//第一个
        T temp2 = function.apply(temp1);
        result.add(temp2);//第二个
        steps++;
        while (test.test(temp1, temp2)) {
            temp1 = temp2;
            temp2 = function.apply(temp1);
            steps++;
            result.add(temp2);
            if (steps >= MaxStep) {
                throw new MaxStepException(MaxStep);
            }
        }
        return result;
    }

    /**
     * @param function
     * @param initValue
     * @param test      最后两个结果作为判定的参数
     * @param <T>
     * @return
     * @throws MaxStepException
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, BiPredicate<T, T> test, int maxStep) {

        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");

        List<T> result = new ArrayList<T>(0);//最终的结果列表
        int steps = 0;
        T temp1 = initValue;
        result.add(temp1);//第一个
        T temp2 = function.apply(temp1);
        result.add(temp2);//第二个
        steps++;
        while (test.test(temp1, temp2)) {
            temp1 = temp2;
            temp2 = function.apply(temp1);
            steps++;
            result.add(temp2);
            if (steps >= maxStep) {
                return result;
            }
        }
        return result;
    }

    /**
     * @param function
     * @param initValue
     * @param test
     * @param m         最后m个结果作为test的参数
     * @param <T>
     * @return
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, Predicate<List<T>> test, int m) throws MaxStepException {

        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");
        ObjectHelper.verifyPositive(m, "m");

        List<T> result = new ArrayList<T>(0);//结果表

        List<T> cache = new ArrayList<T>(0);//参数表
        cache.add(initValue);
        result.add(initValue);
        //先把参数栈填满
        int steps = 0;
        while (cache.size() < m) {
            T temp = function.apply(cache.get(cache.size() - 1));
            steps++;
            result.add(temp);
            if (steps >= MaxStep) {
                throw new MaxStepException(MaxStep);
            }
            cache.add(temp);
        }
        while (test.test(cache)) {
            T last = cache.get(cache.size() - 1);
            T cur = function.apply(last);
            steps++;
            result.add(cur);
            if (steps >= MaxStep) {
                throw new MaxStepException(MaxStep);
            }
            cache.remove(0);//移除最开始
            cache.add(cur);//加入最新的
        }
        return result;
    }

    /**
     * @param function
     * @param initValue
     * @param test
     * @param m
     * @param maxStep   指定要执行的最大步数
     * @param <T>
     * @return
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, Predicate<List<T>> test, int m, int maxStep) {
        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");
        ObjectHelper.verifyPositive(m, "m");
        List<T> result = new ArrayList<T>(0);//结果表
        List<T> cache = new ArrayList<T>(0);//参数表
        cache.add(initValue);
        result.add(initValue);
        //先把参数栈填满
        int steps = 0;
        while (cache.size() < m) {
            T temp = function.apply(cache.get(cache.size() - 1));
            steps++;
            result.add(temp);
            if (steps >= maxStep) {//到达最大步数时，直接返回计算列表
                return result;
            }
            cache.add(temp);
        }
        while (test.test(cache)) {
            T last = cache.get(cache.size() - 1);
            T cur = function.apply(last);
            steps++;
            result.add(cur);
            if (steps >= maxStep) {//到达最大步数时，直接返回
                return result;
            }
            cache.remove(0);//移除最开始
            cache.add(cur);//加入最新的
        }
        return result;
    }

    /**
     * @param function
     * @param initValue
     * @param test
     * @param m
     * @param maxStep
     * @param extra     程序正常退出（1. 达到test条件; 2. 达到最大步数）时，额外执行的步数；可正可负，正表示多执行的步数，负表示少执行的步数
     * @param <T>
     * @return
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, Predicate<List<T>> test, int m, int maxStep, int extra) throws NoEnoughResultException {
        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");
        ObjectHelper.verifyPositive(m, "m");

        List<T> result = nestWhileList(function, initValue, test, m, maxStep);
        if (extra >= 0) {
            T theFinal = result.get(result.size() - 1);
            //考虑到额外执行的次数，所以满足条件的最终结果并非最终结果，需要后推
            for (int i = 0; i < extra; i++) {//由于此时已经不满足条件，所以后续不需要再判断
                T cur = function.apply(theFinal);
                result.add(cur);
                theFinal = cur;
            }
            return result;
        } else {
            //考虑到额外执行的次数，所以满足条件的最终结果并非最终结果，需要前移
            if (result.size() - Math.abs(extra) <= 0) {
                throw new NoEnoughResultException(result.size(), extra);
            } else {
                return result.subList(0, result.size() - Math.abs(extra));//如果越界，抛出异常
            }
        }
    }
}
