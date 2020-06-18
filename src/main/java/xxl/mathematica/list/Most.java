package xxl.mathematica.list;

import java.util.List;

/**
 * 去掉最后一项
 */

public class Most {
    /**
     * 给出去掉最后一个元素的 列表
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> most(List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .subSequence(0, list.size() - 1)
                .asJava();
    }
}
