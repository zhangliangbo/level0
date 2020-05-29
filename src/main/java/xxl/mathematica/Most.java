package xxl.mathematica;

import java.util.ArrayList;
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
        ObjectHelper.requireNonNull(list);
        ObjectHelper.requireLengthNotLessThan(list, 1, "list");
        List<T> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            result.add(list.get(i));
        }
        return result;
    }
}
