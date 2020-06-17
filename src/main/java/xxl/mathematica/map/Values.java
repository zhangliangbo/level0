package xxl.mathematica.map;

import java.util.List;
import java.util.Map;

/**
 * 获取值
 */
public class Values {
    /**
     * 值的列表
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> List<V> values(Map<K, V> map) {
        return io.vavr.collection.List.ofAll(map.values())
                .asJava();
    }

    /**
     * 所有字段的值
     *
     * @param obj
     * @return
     */
    public static List<Object> values(Object obj) {
        return Values.values(Association.association(obj, Keys.keys(obj)));
    }

    /**
     * 给定字段的值
     *
     * @param obj
     * @param fields
     * @return
     */
    public static List<Object> values(Object obj, List<String> fields) {
        return Values.values(Association.association(obj, fields));
    }

}
