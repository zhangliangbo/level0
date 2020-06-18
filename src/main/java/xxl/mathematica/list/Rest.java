package xxl.mathematica.list;

import java.util.List;

/**
 * 去掉第一个
 */

public class Rest {
    /**
     * 去掉 list 中第一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> rest(List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .tail()
                .asJava();
    }
}
