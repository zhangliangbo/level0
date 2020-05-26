package xxl.mathematica;

import xxl.mathematica.exception.ItemNotFoundException;
import xxl.mathematica.function.Predicate;

import java.util.List;


/**
 * 第一个匹配的位置
 */

public class FirstPosition {
    /**
     * 给出 expr 中匹配 pattern 的第一个元素的位置，如果无法找到这样的元素，则给出抛出异常{@link ItemNotFoundException}.
     *
     * @param list
     * @param criteria
     * @param <T>
     * @return
     */
    public static <T> int firstPosition(List<T> list, Predicate<T> criteria) throws ItemNotFoundException {
        ObjectHelper.requireNonNull(list, criteria);
        for (int i = 0; i < list.size(); i++) {
            if (criteria.test(list.get(i))) {
                return i;
            }
        }
        throw new ItemNotFoundException("criteria");
    }

    /**
     * 如果无法找到与 criteria 匹配的元素，给出 default.
     *
     * @param list
     * @param criteria
     * @param def
     * @param <T>
     * @return
     */
    public static <T> int firstPosition(List<T> list, Predicate<T> criteria, int def) {
        ObjectHelper.requireNonNull(list, criteria);
        for (int i = 0; i < list.size(); i++) {
            if (criteria.test(list.get(i))) {
                return i;
            }
        }
        return def;
    }
}
