package xxl.mathematica.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 插入
 */

public class Insert {
    /**
     * 单个位置插入元素
     *
     * @param list
     * @param t
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> insert(List<T> list, T t, int n) {
        return insert(list, t, Collections.singletonList(n));
    }

    /**
     * 多个位置插入元素
     *
     * @param list
     * @param t
     * @param index 正数表示从前到后（0开始），负数表示从后到前（-1开始）
     * @param <T>
     * @return
     */
    public static <T> List<T> insert(List<T> list, T t, List<Integer> index) {
        return io.vavr.collection.List.of(list)
                .map(ts -> {
                    List<T> res = new LinkedList<>(ts);
                    io.vavr.collection.List.ofAll(index)
                            .map(integer -> integer < 0 ? ts.size() + integer + 1 : integer)
                            .sorted()
                            .reverse()
                            .forEach(integer -> res.add(integer, t));
                    return res;
                })
                .get();
    }
}
