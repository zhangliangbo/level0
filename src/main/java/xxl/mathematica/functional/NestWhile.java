package xxl.mathematica.functional;

import io.vavr.control.Try;
import xxl.mathematica.exception.MaxStepException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

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
    public static <T> T nestWhile(Function<T, T> function, T initValue, Predicate<T> test) {
        return Try.ofCallable(() -> {
            T cur = initValue;
            int steps = 0;
            while (test.test(cur)) {
                cur = function.apply(cur);
                ++steps;
                if (steps >= Constant.MaxStep) {
                    throw new MaxStepException(Constant.MaxStep);//达到最大迭代次数，直接抛出异常
                }
            }
            return cur;
        }).getOrNull();
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
    public static <T> T nestWhile(Function<T, T> function, T initValue, BiPredicate<T, T> test) {
        return Try.ofCallable(() -> {
            int steps = 0;
            T cur1 = initValue;
            T cur2 = function.apply(cur1);
            ++steps;
            while (test.test(cur1, cur2)) {
                cur1 = cur2;
                cur2 = function.apply(cur1);
                ++steps;
                if (steps >= Constant.MaxStep) {
                    throw new MaxStepException(Constant.MaxStep);
                }
            }
            return cur2;
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
    public static <T> T nestWhile(Function<T, T> function, T initValue, Predicate<List<T>> test, int m) {
        return Try.ofCallable(() -> {
            List<T> cache = new ArrayList<T>(0);
            cache.add(initValue);
            //先把参数栈填满
            int steps = 0;
            while (cache.size() < m) {
                T temp = function.apply(cache.get(cache.size() - 1));
                ++steps;
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
        }).getOrNull();
    }
}
