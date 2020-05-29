package xxl.mathematica;

import java.util.HashMap;
import java.util.Map;

/**
 * 关联
 */
public class Association {
    /**
     * 根据规则生成关联
     *
     * @param rules
     * @param <K>
     * @param <V>
     * @return
     */
    @SafeVarargs
    public static <K, V> Map<K, V> association(Rule<K, V>... rules) {
        ObjectHelper.requireNonNull((Object) rules);
        Map<K, V> map = new HashMap<>();
        for (Rule<K, V> rule : rules) {
            if (rule != null) {
                map.put(rule.getKey(), rule.getValue());
            }
        }
        return map;
    }
}
