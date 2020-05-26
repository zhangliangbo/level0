package xxl.mathematica;

import xxl.mathematica.function.Function;

import java.util.HashMap;
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
        ObjectHelper.requireNonNull(f, map);
        Map<K2, V> result = new HashMap<>();
        for (Map.Entry<K1, V> entry : map.entrySet()) {
            result.put(f.apply(entry.getKey()), entry.getValue());
        }
        return result;
    }

}
