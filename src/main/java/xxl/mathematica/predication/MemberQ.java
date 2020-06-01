package xxl.mathematica.predication;


import xxl.mathematica.logic.AnyTrue;

import java.util.List;
import java.util.function.BiPredicate;

/**
 * 成员判定
 */

public class MemberQ {
    /**
     * 用来判断 list 的一个元素是否与 item 匹配，若是，则返回 True，否则返回 False.
     *
     * @param list
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean memberQ(List<T> list, T item, BiPredicate<T, T> p) {
        return AnyTrue.anyTrue(list, t -> p.test(item, t));
    }

    /**
     * 使用equals方法比较相等性
     *
     * @param list
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean memberQ(List<T> list, T item) {
        return memberQ(list, item, Object::equals);
    }
}
