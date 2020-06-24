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
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
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
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                field.set(t, map.get(field.getName()));
            }
            return t;
        }).getOrNull();
    }

    /**
     * 把一个对象的同名字段放入另外一个字段
     *
     * @param src
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T populateObject(T src, T t) {
        return Try.ofCallable(() -> {
            Map<String, Object> map = Association.association(src);
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                field.set(t, map.get(field.getName()));
            }
            return t;
        }).getOrNull();
    }

    /**
     * 把一个对象的同名字段放入另外一个字段
     *
     * @param src
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T populateObject(T src, Class<T> cls) {
        return Try.ofCallable(() -> {
            Map<String, Object> map = Association.association(src);
            T t = cls.getDeclaredConstructor().newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                field.set(t, map.get(field.getName()));
            }
            return t;
        }).getOrNull();
    }
}
