package xxl.mathematica.map;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import xxl.mathematica.Rule;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
        return io.vavr.collection.List.ofAll(Arrays.asList(rules))
                .toJavaMap(rule -> Tuple.of(rule.getKey(), rule.getValue()));
    }

    /**
     * 把对象指定字段的数据封装为Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> association(Object obj) {
        return association(obj, obj.getClass());
    }

    /**
     * 有一个类的所有字段指定键的集合
     *
     * @param obj
     * @param cls
     * @return
     */
    public static Map<String, Object> association(Object obj, Class<?> cls) {
        return io.vavr.collection.List.of(cls.getDeclaredFields())
                .toJavaMap((Function<Field, Tuple2<String, Object>>) field -> {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    try {
                        return Tuple.of(field.getName(), field.get(obj));
                    } catch (Throwable e) {
                        return Tuple.of(field.getName(), null);
                    }
                });
    }

    /**
     * 把对象指定字段的数据封装为Map
     *
     * @param src
     * @param fields
     * @return
     */
    public static Map<String, Object> association(Object src, List<String> fields) {
        return io.vavr.collection.List.ofAll(fields)
                .toJavaMap((Function<String, Tuple2<String, Object>>) s -> {
                    try {
                        Field field = src.getClass().getField(s);
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        return Tuple.of(s, field.get(src));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        return Tuple.of(s, null);
                    }
                });
    }

}
