package xxl.mathematica.map;

import io.vavr.control.Try;

import java.lang.reflect.Field;
import java.util.Map;

public class PopulateObject {
    /**
     * 把字典的值放入到对象中
     *
     * @param <T>
     * @return
     */
    public static <T> T populateObject(Map<String, Object> map, Class<T> cls) {
        return Try.ofCallable(() -> {
            Field[] fields = cls.getDeclaredFields();
            T t = cls.getDeclaredConstructor().newInstance();
            for (Field field : fields) {
                field.set(t, map.get(field.getName()));
            }
            return t;
        }).getOrNull();
    }

    /**
     * 把字典的值放入到对象中
     *
     * @param map
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T populateObject(Map<String, Object> map, T t) {
        return Try.ofCallable(() -> {
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.set(t, map.get(field.getName()));
            }
            return t;
        }).getOrNull();
    }
}
