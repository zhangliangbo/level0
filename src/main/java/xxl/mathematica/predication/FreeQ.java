package xxl.mathematica.predication;

import xxl.mathematica.ObjectHelper;
import xxl.mathematica.function.BiPredicate;

import java.util.List;


/**
 * 判定是否不存在匹配
 */

public class FreeQ {
    /**
     * 如果在 list 中没有匹配 item 的子表达式，则生成 True，否则生成 False.
     *
     * @param list
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean freeQ(List<T> list, T item, BiPredicate<T, T> p) {
        ObjectHelper.requireNonNull(list, item, p);
        for (T t : list) {
            if (p.test(t, item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用equals方法比较相等性
     *
     * @param list
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean freeQ(List<T> list, T item) {
        return freeQ(list, item, new BiPredicate<T, T>() {
            @Override
            public boolean test(T t, T t2) {
                return t.equals(t2);
            }
        });
    }
}
