package xxl.mathematica.list;

import java.util.List;

/**
 * 反向排序
 */
public class Reverse {
    /**
     * 反向排序
     *
     * @param list
     * @return
     */
    public static <T> List<T> reverse(List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .reverse()
                .asJava();
    }
}
