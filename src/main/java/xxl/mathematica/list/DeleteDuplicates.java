package xxl.mathematica.list;

import java.util.List;

/**
 * 删除重复元素
 */

public class DeleteDuplicates {

    /**
     * 使用equals判断相等性
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> deleteDuplicates(List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .distinct()
                .asJava();
    }
}
