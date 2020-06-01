package xxl.mathematica.functional;

import io.vavr.control.Try;
import xxl.mathematica.function.BiFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 折叠列表
 */

public class FoldList {
    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param initValue
     * @param list      列表
     * @param <T>
     * @return
     */
    public static <T> List<T> foldList(BiFunction<T, T, T> function, T initValue, List<T> list) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> res = new ArrayList<>(1);
                res.add(initValue);
                T last = initValue;//上一个是第一个
                for (T cur : list) {
                    T next = function.apply(last, cur);
                    res.add(next);
                    last = next;//重置上一个
                }
                return res;
            }
        }).getOrNull();
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param list     列表
     * @param <T>
     * @return
     */
    public static <T> List<T> foldList(BiFunction<T, T, T> function, List<T> list) {
        return Try.ofCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<T> res = new ArrayList<T>(1);
                res.add(list.get(0));
                T last = list.get(0);//上一个是第一个
                for (int i = 1; i < list.size(); i++) {
                    T cur = list.get(i);
                    T next = function.apply(last, cur);
                    res.add(next);
                    last = next;//重置上一个
                }
                return res;
            }
        }).getOrNull();
    }
}
