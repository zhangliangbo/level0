package xxl.mathematica.predication;

import xxl.mathematica.logic.NoneTrue;

import java.util.List;
import java.util.function.BiPredicate;


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
        return NoneTrue.noneTrue(list, t -> p.test(item, t));
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
        return freeQ(list, item, Object::equals);
    }
}
