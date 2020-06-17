package xxl.mathematica.map;

import xxl.mathematica.function.Predicate;

import java.util.Map;

/**
 * 键选择
 */
public class KeySelect {
    /**
     * 键选择
     *
     * @param src
     * @param p
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> keySelect(Map<K, V> src, Predicate<K> p) {
        return io.vavr.collection.HashMap.ofAll(src)
                .filter(tuple2 -> p.test(tuple2._1()))
                .toJavaMap();
    }
}
