package xxl.mathematica;

import xxl.mathematica.function.BiPredicate;
import xxl.mathematica.function.Function;
import xxl.mathematica.predication.FreeQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据指定条件删除重复元素
 */

public class DeleteDuplicatesBy {
    /**
     * @param list     列表
     * @param function 条件函数
     * @param test     相等函数
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<T> deleteDuplicatesBy(List<T> list, Function<T, R> function, BiPredicate<R, R> test) {
        ObjectHelper.requireNonNull(list, function, test);
        if (list.size() == 0) {
            return new ArrayList<>();
        } else {
            List<T> result = new ArrayList<>();
            result.add(list.get(0));//第一个元素肯定不和其他元素重复
            for (int i = 1; i < list.size(); i++) {
                if (FreeQ.freeQ(list, list.get(i), new BiPredicate<T, T>() {
                    @Override
                    public boolean test(T t, T t2) {
                        return test.test(function.apply(t), function.apply(t2));
                    }
                })) {
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
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<T> deleteDuplicatesBy(List<T> list, Function<T, R> function) {
        return deleteDuplicatesBy(list, function, new BiPredicate<R, R>() {
            @Override
            public boolean test(R r, R r2) {
                return r.equals(r2);
            }
        });
    }
}
