package xxl.mathematica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 键列表
 */
public class Keys {
    /**
     * 键的列表
     *
     * @param <K>
     * @param <V>
     * @param map
     * @return
     */
    public static <K, V> List<K> keys(Map<K, V> map) {
        ObjectHelper.requireNonNull(map);
        return new ArrayList<>(map.keySet());
    }
}
