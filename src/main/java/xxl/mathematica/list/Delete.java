package xxl.mathematica.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 删除
 */

public class Delete {
    /**
     * 用来删除 list 中位置 n 的元素.如果 n 是负数，该位置从表达式的末尾计数.
     *
     * @param list
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> delete(List<T> list, int n) {
        return delete(list, Collections.singletonList(n));
    }

    /**
     * 多个位置删除元素
     *
     * @param list
     * @param index
     * @param <T>
     * @return
     */
    public static <T> List<T> delete(List<T> list, List<Integer> index) {
        return io.vavr.collection.List.of(list)
                .map(ts -> {
                    List<T> res = new LinkedList<>(ts);
                    io.vavr.collection.List.ofAll(index)
                            .map(integer -> integer < 0 ? ts.size() + integer : integer)
                            .sorted()
                            .reverse()
                            .forEach(new Consumer<Integer>() {
                                @Override
                                public void accept(Integer integer) {
                                    int cur = integer;
                                    res.remove(cur);
                                }
                            });
                    return res;
                })
                .get();
    }
}
