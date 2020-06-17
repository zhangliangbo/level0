package xxl.mathematica.map;

import xxl.mathematica.function.BiFunction;

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
        return io.vavr.collection.HashMap.ofAll(map)
                .toList()
                .map(tuple2 -> f.apply(tuple2._1(), tuple2._2()))
                .toJavaList();
    }
}
