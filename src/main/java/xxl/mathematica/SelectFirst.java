package xxl.mathematica;

import xxl.mathematica.exception.ItemNotFoundException;
import xxl.mathematica.function.Predicate;

import java.util.List;

/**
 * 选择第一个
 */

public class SelectFirst {
    /**
     * 给出第一个 Subscript[e, i]，满足 crit[Subscript[e, i]] 是 True 或者找不到任何内容时抛出异常
     *
     * @param list
     * @param criteria
     * @param <T>
     * @return
     * @throws ItemNotFoundException
     */
    public static <T> T selectFirst(List<T> list, Predicate<T> criteria) throws ItemNotFoundException {
        T res = selectFirst(list, criteria, null);
        if (res == null) {
            throw new ItemNotFoundException("criteria");
        } else {
            return res;
        }
    }

    /**
     * 给出 default，如果不存在满足 criteria 是 True 的 元素
     *
     * @param list
     * @param criteria
     * @param def
     * @param <T>
     * @return
     */
    public static <T> T selectFirst(List<T> list, Predicate<T> criteria, T def) {
        ObjectHelper.requireNonNull(list, criteria);
        for (T t : list) {
            if (criteria.test(t)) {
                return t;
            }
        }
        return def;
    }
}
