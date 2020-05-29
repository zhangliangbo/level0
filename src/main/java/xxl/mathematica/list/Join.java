package xxl.mathematica.list;

import java.util.List;

/**
 * 连接
 */
public class Join {
    /**
     * 连接两个列表
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> List<T> join(List<T> list1, List<T> list2) {
        return io.vavr.collection.List.ofAll(list1)
                .appendAll(list2)
                .asJava();
    }
}
