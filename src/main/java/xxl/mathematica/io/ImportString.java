package xxl.mathematica.io;

import com.google.gson.reflect.TypeToken;
import io.vavr.control.Try;
import org.apache.commons.lang3.ClassUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import xxl.mathematica.map.AssociationMap;
import xxl.mathematica.map.KeySelect;
import xxl.mathematica.map.Keys;
import xxl.mathematica.single.GsonSingle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.*;

/**
 * 导入字符串
 */
public class ImportString {
    /**
     * 导入字符串
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T importJsonObject(String json, Class<T> cls){
        return GsonSingle.instance().fromJson(json,cls);
    }

    /**
     * 导入json字符串为Map对象
     *
     * @param json
     * @return
     */
    public static Map<String, Object> importJsonMapObject(String json) {
        return GsonSingle.instance().fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    /**
     * 导入json字符串为Map字符串
     *
     * @param json
     * @return
     */
    public static Map<String, String> importJsonMapString(String json) {
        Map<String, Object> res = importJsonMapObject(json);
        Map<String, Object> select = KeySelect.keySelect(res, s -> {
            if (res.get(s) != null) {
                Class<?> cls = res.get(s).getClass();
                return cls.isPrimitive() || ClassUtils.isPrimitiveWrapper(cls) || cls.equals(String.class);
            } else {
                return false;
            }
        });
        return AssociationMap.associationMap(t -> String.valueOf(select.get(t)), Keys.keys(select));
    }

    /**
     * 导入xml
     *
     * @param xml
     * @param <T>
     * @return
     */
    public static <T> T importXml(String xml, Class<T> cls) {
        try {
            JAXBContext context = JAXBContext.newInstance(cls);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 检索数据
     *
     * @param element
     * @param parent
     */
    private static void retrieveElement(Element element, Map<String, Object> parent) {
        if (element.isTextOnly()) {
            parent.put(element.getName(), element.getData());
        } else {
            Iterator<Element> iterator = element.elementIterator();
            while (iterator.hasNext()) {
                Element e = iterator.next();
                if (e.isTextOnly()) {
                    parent.put(e.getName(), e.getData());
                } else {
                    if (parent.containsKey(e.getName())) {
                        Object object = parent.get(e.getName());
                        if (object instanceof Map) {
                            //取出原来的Map
                            Map<String, Object> one = (Map<String, Object>) object;
                            //Map替换为List
                            List<Map<String, Object>> list = new ArrayList<>();
                            parent.put(e.getName(), list);
                            //加入原来的Map和现在的Map
                            list.add(one);
                            Map<String, Object> cur = new HashMap<>();
                            retrieveElement(e, cur);
                            list.add(cur);
                        } else {
                            List<Map<String, Object>> list = (List<Map<String, Object>>) object;
                            Map<String, Object> cur = new HashMap<>();
                            retrieveElement(e, cur);
                            list.add(cur);
                        }
                    } else {
                        Map<String, Object> child = new HashMap<>();
                        parent.put(e.getName(), child);
                        retrieveElement(e, child);
                    }
                }
            }
        }
    }

    /**
     * 导入为Map
     *
     * @param xml
     * @return
     */
    public static Map<String, Object> importXml(String xml) {
        return Try.ofCallable(() -> {
            Document document = DocumentHelper.parseText(xml);
            Map<String, Object> map = new HashMap<>();
            Element rootElement = document.getRootElement();
            retrieveElement(rootElement, map);
            return map;
        }).getOrNull();
    }
}
