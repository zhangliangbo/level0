package xxl.mathematica.io;

import xxl.mathematica.single.GsonSingle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

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
