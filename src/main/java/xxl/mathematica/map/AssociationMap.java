package xxl.mathematica.map;

import io.vavr.Tuple;
import xxl.mathematica.Rule;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
        return io.vavr.collection.List.ofAll(list)
                .toJavaMap(k -> Tuple.of(k, f.apply(k)));
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
        return io.vavr.collection.HashMap.ofAll(map)
                .map((k1, v1) -> {
                    Rule<K2, V2> res = f.apply(Rule.valueOf(k1, v1));
                    return Tuple.of(res.getKey(), res.getValue());
                })
                .toJavaMap();
    }
}
