package xxl.mathematica.java;

import xxl.mathematica.Rule;
import xxl.mathematica.time.DateString;

import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 把java类型转成mathematica类型
 *
 * @author zhangliangbo
 * @since 2020/10/5
 **/

public class Converter {
    /**
     * 字典转成列表
     *
     * @param map 字典
     * @return 列表
     */
    public static <K, V> List<Rule<Object, Object>> map(Map<K, V> map) {
        return Optional.ofNullable(map)
                .orElse(new HashMap<>(1))
                .entrySet()
                .stream()
                .map(new Function<Map.Entry<K, V>, Rule<Object, Object>>() {
                    @Override
                    public Rule<Object, Object> apply(Map.Entry<K, V> entry) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        if (entry.getValue() instanceof Timestamp) {
                            value = DateString.dateString((Timestamp) entry.getValue());
                        } else if (entry.getValue() instanceof Date) {
                            value = DateString.dateString((Date) entry.getValue());
                        }
                        return Rule.valueOf(key, value);
                    }
                })
                .collect(Collectors.toList());
    }
}
