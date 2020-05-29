package xxl.mathematica;

import xxl.mathematica.function.BiPredicate;
import xxl.mathematica.predication.FreeQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除重复元素
 */

public class DeleteDuplicates {
    /**
     * 将 test 应用到元素对中，确定它们是否是重复的
     * 不对元素重排序，仅删除它们
     *
     * @param list
     * @param test
     * @param <T>
     * @return
     */
    public static <T> List<T> deleteDuplicates(List<T> list, BiPredicate<T, T> test) {
        ObjectHelper.requireNonNull(list, test);
        if (list.size() == 0 || list.size() == 1) {//一个元素不存在重复值
            return new ArrayList<>(list);
        } else {
            List<T> result = new ArrayList<>();
            result.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (FreeQ.freeQ(result, list.get(i), test)) {
                    result.add(list.get(i));
                }
            }
            return result;
        }
    }

    /**
     * 使用equals判断相等性
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> deleteDuplicates(List<T> list) {
        return deleteDuplicates(list, new BiPredicate<T, T>() {
            @Override
            public boolean test(T t, T t2) {
                return t.equals(t2);
            }
        });
    }
}
