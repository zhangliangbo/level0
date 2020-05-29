package xxl.mathematica;

import xxl.mathematica.function.Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关联映射
 */
public class AssociationMap {
    /**
     * 根据键列表创建关联
     *
     * @param f
     * @param list
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> associationMap(Function<K, V> f, List<K> list) {
        ObjectHelper.requireNonNull(f, list);
        Map<K, V> result = new HashMap<>();
        for (K k : list) {
            result.put(k, f.apply(k));
        }
        return result;
    }

    /**
     * 根据旧的关联创建新的关联
     *
     * @param f
     * @param map
     * @param <K1>
     * @param <V1>
     * @param <K2>
     * @param <V2>
     * @return
     */
    public static <K1, V1, K2, V2> Map<K2, V2> associationMap(Function<Rule<K1, V1>, Rule<K2, V2>> f, Map<K1, V1> map) {
        ObjectHelper.requireNonNull(f, map);
        Map<K2, V2> result = new HashMap<>();
        for (Map.Entry<K1, V1> entry1 : map.entrySet()) {
            Rule<K2, V2> entry2 = f.apply(Rule.valueOf(entry1.getKey(), entry1.getValue()));
            result.put(entry2.getKey(), entry2.getValue());
        }
        return result;
    }
}
