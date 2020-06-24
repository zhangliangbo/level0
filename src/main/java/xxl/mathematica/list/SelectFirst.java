package xxl.mathematica.list;

import xxl.mathematica.exception.ItemNotFoundException;

import java.util.List;
import java.util.function.Predicate;

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
        return selectFirst(list, criteria, null);
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
        return io.vavr.collection.List.ofAll(list)
                .find(criteria)
                .getOrElse(def);
    }
}
