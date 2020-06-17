package xxl.mathematica.map;

import io.vavr.Tuple;
import xxl.mathematica.function.Function;

import java.util.Map;

/**
 * 键映射
 */
public class KeyMap<K1, K2> {

    /**
     * 作用函数到映射的键上
     *
     * @param f
     * @param map
     * @param <K1>
     * @param <K2>
     * @param <V>
     * @return
     */
    public static <K1, K2, V> Map<K2, V> keyMap(Function<K1, K2> f, Map<K1, V> map) {
        return io.vavr.collection.HashMap.ofAll(map)
                .map((k1, v) -> Tuple.of(f.apply(k1), v))
                .toJavaMap();
    }

}
