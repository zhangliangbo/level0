package xxl.mathematica.list;

import java.util.List;

/**
 * 提取
 */

public class Extract {
    /**
     * 提取 list 在索引表处的值
     *
     * @param list
     * @param indexList
     * @param <T>
     * @return
     */
    public static <T> List<T> extract(List<T> list, List<Integer> indexList) {
        return io.vavr.collection.List.ofAll(indexList)
                .map(list::get)
                .asJava();
    }
}
