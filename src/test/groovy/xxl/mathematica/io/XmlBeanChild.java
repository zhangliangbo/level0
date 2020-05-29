package xxl.mathematica.io;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class XmlBeanChild {

    @XmlElement
    public String name;

    @XmlElement
    public int weight;

    @Override
    public String toString() {
        return "XmlBeanChild{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
