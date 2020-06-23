package xxl.mathematica.map;

import java.lang.reflect.Field;
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
        return io.vavr.collection.HashSet.ofAll(map.keySet())
                .toJavaList();
    }

    /**
     * 获取对象的所有字段
     *
     * @param obj
     * @return
     */
    public static List<String> keys(Object obj) {
        return keys(obj.getClass());
    }

    /**
     * 列出一个类的所有字段
     *
     * @param cls
     * @return
     */
    public static List<String> keys(Class<?> cls) {
        return io.vavr.collection.List.of(cls.getDeclaredFields())
                .map(Field::getName)
                .asJava();
    }
}
