package xxl.mathematica.functional;

import io.vavr.control.Try;
import xxl.mathematica.exception.MaxStepException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static xxl.mathematica.functional.Constant.MaxStep;

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
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, Predicate<T> test) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> result = new ArrayList<T>(0);
                T cur = initValue;
                result.add(cur);
                int steps = 0;
                while (test.test(cur)) {
                    cur = function.apply(cur);
                    result.add(cur);
                    ++steps;
                    if (steps >= MaxStep) {
                        throw new MaxStepException(MaxStep);//达到最大迭代次数，直接抛出异常
                    }
                }
                return result;
            }
        }).getOrNull();
    }

    /**
     * @param function
     * @param initValue
     * @param test      最后两个结果作为判定的参数
     * @param <T>
     * @return
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, BiPredicate<T, T> test) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> result = new ArrayList<T>(0);//最终的结果列表
                int steps = 0;
                T cur1 = initValue;
                T cur2 = function.apply(cur1);
                result.add(cur1);//第一个
                result.add(cur2);//第二个
                ++steps;
                while (test.test(cur1, cur2)) {
                    cur1 = cur2;
                    cur2 = function.apply(cur1);
                    ++steps;
                    result.add(cur2);
                    if (steps >= MaxStep) {
                        throw new MaxStepException(MaxStep);
                    }
                }
                return result;
            }
        }).getOrNull();
    }

    /**
     * @param function
     * @param initValue
     * @param test
     * @param m         最后m个结果作为test的参数
     * @param <T>
     * @return
     */
    public static <T> List<T> nestWhileList(Function<T, T> function, T initValue, Predicate<List<T>> test, int m) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> result = new ArrayList<T>(0);//结果表
                List<T> cache = new ArrayList<T>(0);//参数表
                cache.add(initValue);
                result.add(initValue);
                //先把参数栈填满
                int steps = 0;
                while (cache.size() < m) {
                    T temp = function.apply(cache.get(cache.size() - 1));
                    ++steps;
                    result.add(temp);
                    if (steps >= MaxStep) {
                        throw new MaxStepException(MaxStep);
                    }
                    cache.add(temp);
                }
                while (test.test(cache)) {
                    T last = cache.get(cache.size() - 1);
                    T cur = function.apply(last);
                    ++steps;
                    result.add(cur);
                    if (steps >= MaxStep) {
                        throw new MaxStepException(MaxStep);
                    }
                    cache.remove(0);//移除最开始
                    cache.add(cur);//加入最新的
                }
                return result;
            }
        }).getOrNull();
    }
}
