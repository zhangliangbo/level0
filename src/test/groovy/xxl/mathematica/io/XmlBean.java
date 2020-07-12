package xxl.mathematica.io;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlBean {

    @XmlElement
    public int age;
    @XmlElement
    public List<XmlBeanChild> goods;
    @XmlElement
    public String name;

    @Override
    public String toString() {
        return "XmlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", goods=" + goods +
                '}';
    }
}
