package xxl.mathematica;

import xxl.mathematica.list.Drop;
import xxl.mathematica.list.Take;

import java.util.ArrayList;
import java.util.List;

/**
 * 提取删除部分
 */

public class TakeDrop {
    /**
     * 给出 {list1,list2} 对，其中list 包含 list 的前 n 个元素， list2 包含其他的元素.
     *
     * @param list
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> takeDrop(List<T> list, int n) {
        ObjectHelper.requireNonNull(list);
        if (Math.abs(n) > list.size()) {
            throw new IndexOutOfBoundsException("can not take " + n + " elements from list, " + "list only has " + list.size() + " elements");
        }
        List<List<T>> result = new ArrayList<>();
        if (n >= 0) {
            List<T> take = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                take.add(list.get(i));
            }
            result.add(take);
            List<T> drop = new ArrayList<>();
            for (int i = n; i < list.size(); i++) {
                drop.add(list.get(i));
            }
            result.add(drop);
            return result;
        } else {
            List<T> take = new ArrayList<>();
            for (int i = list.size() + n; i < list.size(); i++) {
                take.add(list.get(i));
            }
            result.add(take);
            List<T> drop = new ArrayList<>();
            for (int i = 0; i < list.size() + n; i++) {
                drop.add(list.get(i));
            }
            result.add(drop);
            return result;
        }
    }

    /**
     * 给出 {Take[list,seq],Drop[list,seq]} 对
     * 默认步长是1
     *
     * @param list
     * @param m    开始索引
     * @param n    结束索引
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> takeDrop(List<T> list, int m, int n) {
        ObjectHelper.requireNonNull(list);
        List<List<T>> result = new ArrayList<>();
        result.add(Take.take(list, m, n));
        result.add(Drop.drop(list, m, n));
        return result;
    }
}
