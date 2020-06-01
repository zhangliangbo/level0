package xxl.mathematica.predication;


import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

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
        return io.vavr.collection.List.ofAll(list)
                .find(t -> p.test(item, t))
                .isDefined();
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
