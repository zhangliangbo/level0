package xxl.mathematica;

import xxl.mathematica.function.BiFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 键值映射
 */
public class KeyValueMap {
    /**
     * 将函数作用于映射的键和值上
     *
     * @param f
     * @param map
     * @param <K>
     * @param <V>
     * @param <T>
     * @return
     */
    public static <K, V, T> List<T> keyValueMap(BiFunction<K, V, T> f, Map<K, V> map) {
        ObjectHelper.requireNonNull(f, map);
        List<T> result = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.add(f.apply(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}
