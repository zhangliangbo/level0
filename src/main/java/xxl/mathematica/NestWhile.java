package xxl.mathematica;

import xxl.mathematica.exception.MaxStepException;
import xxl.mathematica.exception.NoEnoughResultException;
import xxl.mathematica.function.BiPredicate;
import xxl.mathematica.function.Function;
import xxl.mathematica.function.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * 从 initValue 开始，然后重复应用 function 直到 test 不再得到 True 为止.
 */

public class NestWhile {

    /**
     * 从 initValue 开始，然后重复应用 function 直到 test 不再得到 True 为止，并返回最终结果
     *
     * @param function
     * @param initValue
     * @param test
     * @param <T>
     * @return
     */
    public static <T> T nestWhile(Function<T, T> function, T initValue, Predicate<T> test) throws MaxStepException {
        ObjectHelper.requireNonNull(function, initValue, test);

        T input = initValue;
        T output = initValue;
        int steps = 0;
        while (test.test(input)) {
            output = function.apply(input);
            steps++;
            input = output;
            if (steps >= Constant.MaxStep) {
                throw new MaxStepException(Constant.MaxStep);//达到最大迭代次数，直接抛出异常
            }
        }
        return output;
    }


    /**
     * 将最后两个结果作为test的参数
     *
     * @param function
     * @param initValue
     * @param test
     * @param <T>
     * @return
     */
    public static <T> T nestWhile(Function<T, T> function, T initValue, BiPredicate<T, T> test) throws MaxStepException {

        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");

        int steps = 0;
        T temp1 = initValue;
        T temp2 = function.apply(temp1);
        steps++;
        while (test.test(temp1, temp2)) {
            temp1 = temp2;
            temp2 = function.apply(temp1);
            steps++;
            if (steps >= Constant.MaxStep) {
                throw new MaxStepException(Constant.MaxStep);
            }
        }
        return temp2;
    }


    /**
     * 将最后两个结果作为test的参数
     *
     * @param function
     * @param initValue
     * @param test
     * @param <T>
     * @return
     */
    public static <T> T nestWhile(Function<T, T> function, T initValue, BiPredicate<T, T> test, int maxStep) {

        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");

        int steps = 0;
        T temp1 = initValue;
        T temp2 = function.apply(temp1);
        steps++;
        while (test.test(temp1, temp2)) {
            temp1 = temp2;
            temp2 = function.apply(temp1);
            steps++;
            if (steps >= maxStep) {
                return temp2;
            }
        }
        return temp2;
    }


    /**
     * @param function
     * @param initValue
     * @param test
     * @param m         最后m个结果作为test的参数
     * @param <T>
     * @return
     */
    public static <T> T nestWhile(Function<T, T> function, T initValue, Predicate<List<T>> test, int m) throws MaxStepException {

        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");
        ObjectHelper.verifyPositive(m, "m");

        List<T> cache = new ArrayList<T>(0);
        cache.add(initValue);
        //先把参数栈填满
        int steps = 0;
        while (cache.size() < m) {
            T temp = function.apply(cache.get(cache.size() - 1));
            steps++;
            if (steps >= Constant.MaxStep) {
                throw new MaxStepException(Constant.MaxStep);
            }
            cache.add(temp);
        }
        while (test.test(cache)) {
            T last = cache.get(cache.size() - 1);
            T cur = function.apply(last);
            steps++;
            if (steps >= Constant.MaxStep) {
                throw new MaxStepException(Constant.MaxStep);
            }
            cache.remove(0);//移除最开始
            cache.add(cur);//加入最新的
        }
        return cache.get(cache.size() - 1);
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
    public static <T> T nestWhile(Function<T, T> function, T initValue, Predicate<List<T>> test, int m, int maxStep) {
        ObjectHelper.requireNonNull(function, "function");
        ObjectHelper.requireNonNull(initValue, "initValue");
        ObjectHelper.requireNonNull(test, "test");
        ObjectHelper.verifyPositive(m, "m");

        List<T> cache = new ArrayList<T>(0);
        cache.add(initValue);
        //先把参数栈填满
        int steps = 0;
        while (cache.size() < m) {
            T temp = function.apply(cache.get(cache.size() - 1));
            steps++;
            if (steps >= maxStep) {//到达最大步数时，直接返回
                return temp;
            }
            cache.add(temp);
        }
        while (test.test(cache)) {
            T last = cache.get(cache.size() - 1);
            T cur = function.apply(last);
            steps++;
            if (steps >= maxStep) {//到达最大步数时，直接返回
                return cur;
            }
            cache.remove(0);//移除最开始
            cache.add(cur);//加入最新的
        }
        return cache.get(cache.size() - 1);
    }


    /**
     * @param function
     * @param initValue
     * @param test
     * @param m
     * @param maxStep
     * @param extra     函数正常退出（1. 达到test条件; 2. 达到最大步数）时，额外执行的步数；可正可负，正表示多执行的步数，负表示少执行的步数
     * @param <T>
     * @return
     */
    public static <T> T nestWhile(Function<T, T> function, T initValue, Predicate<List<T>> test, int m, int maxStep, int extra) throws NoEnoughResultException {
        List<T> list = NestWhileList.nestWhileList(function, initValue, test, m, maxStep, extra);
        return list.get(list.size() - Math.abs(extra));
    }


}
