package xxl.mathematica.io;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlBean {

    @XmlElement
    public String name;

    @XmlElement
    public int age;

    @XmlAttribute
    public int state;

    @XmlElement
    public List<XmlBeanChild> goods;

    @Override
    public String toString() {
        return "XmlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", state=" + state +
                ", goods=" + goods +
                '}';
    }
}
