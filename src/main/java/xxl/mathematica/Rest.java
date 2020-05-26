package xxl.mathematica;

import java.util.ArrayList;
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
        ObjectHelper.requireNonNull(list);
        ObjectHelper.requireLengthNotLessThan(list, 1, "list");
        List<T> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }
}
