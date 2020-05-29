package xxl.mathematica.predication;

import xxl.mathematica.ObjectHelper;
import xxl.mathematica.function.BiPredicate;

import java.util.List;

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
        ObjectHelper.requireNonNull(list, item, p);
        for (T t : list) {
            if (p.test(t, item)) {
                return true;
            }
        }
        return false;
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
        return memberQ(list, item, new BiPredicate<T, T>() {
            @Override
            public boolean test(T t, T t2) {
                return t.equals(t2);
            }
        });
    }
}
