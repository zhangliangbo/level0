package xxl.mathematica.map;

import io.vavr.control.Try;

import java.lang.reflect.Field;
import java.util.Map;

public class PopulateObject {
    /**
     * 赋值过程
     *
     * @param map
     * @param t
     * @param <T>
     * @return
     */
    private static <T> T populate(Map<String, Object> map, T t) throws IllegalAccessException {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object value = map.get(field.getName());
            if (value != null) {
                field.set(t, value);
            }
        }
        return t;
    }

    /**
     * 把字典的值放入到对象中
     *
     * @param <T>
     * @return
     */
    public static <T> T populateObject(Map<String, Object> map, Class<T> cls) {
        return Try.ofCallable(() -> {
            T t = cls.getDeclaredConstructor().newInstance();
            return populate(map, t);
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
        return Try.ofCallable(() -> populate(map, t)).getOrNull();
    }

    /**
     * 把一个对象的同名字段放入另外一个字段
     *
     * @param src
     * @param t
     * @param <SRC>
     * @param <T>
     * @return
     */
    public static <SRC, T> T populateObject(SRC src, T t) {
        return Try.ofCallable(() -> {
            Map<String, Object> map = Association.association(src);
            return populate(map, t);
        }).getOrNull();
    }

    /**
     * 把一个对象的同名字段放入另外一个字段
     *
     * @param src
     * @param cls
     * @param <SRC>
     * @param <T>
     * @return
     */
    public static <SRC, T> T populateObject(SRC src, Class<T> cls) {
        return Try.ofCallable(() -> {
            Map<String, Object> map = Association.association(src);
            T t = cls.getDeclaredConstructor().newInstance();
            return populate(map, t);
        }).getOrNull();
    }
}
