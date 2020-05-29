package xxl.mathematica;

import xxl.mathematica.function.Predicate;

import java.util.HashMap;
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
        ObjectHelper.requireNonNull(src, p);
        Map<K, V> res = new HashMap<>();
        for (Map.Entry<K, V> entry : src.entrySet()) {
            if (p.test(entry.getKey())) {
                res.put(entry.getKey(), entry.getValue());
            }
        }
        return res;
    }
}
