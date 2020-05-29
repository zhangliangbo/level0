package xxl.mathematica.io;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import xxl.mathematica.single.GsonSingle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

/**
 * 导出字符串
 */
public class ExportString {
    /**
     * 导出json字符串
     *
     * @param object
     * @return
     */
    public static String exportStringJson(Object object) {
        return GsonSingle.instance().toJson(object);
    }

    /**
     * 导出为map字符串
     *
     * @param object
     * @return
     */
    public static Map<String, String> exportStringMap(Object object) {
        return io.vavr.collection.List.of(object.getClass().getDeclaredFields())
                .toJavaMap((Function<Field, Tuple2<String, String>>) field -> {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    try {
                        return Tuple.of(field.getName(), field.get(object).toString());
                    } catch (IllegalAccessException e) {
                        return Tuple.of(field.getName(), null);
                    }
                });
    }

    /**
     * 导出为map对象
     *
     * @param object
     * @return
     */
    public static Map<String, Object> exportObjectMap(Object object) {
        return io.vavr.collection.List.of(object.getClass().getDeclaredFields())
                .toJavaMap((Function<Field, Tuple2<String, Object>>) field -> {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    try {
                        return Tuple.of(field.getName(), field.get(object));
                    } catch (IllegalAccessException e) {
                        return Tuple.of(field.getName(), null);
                    }
                });
    }

    /**
     * 导出为xml格式
     *
     * @param obj
     * @return
     */
    public static String exportStringXml(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            String result = writer.toString();
            writer.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
