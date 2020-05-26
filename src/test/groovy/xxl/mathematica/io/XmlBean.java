package xxl.mathematica.io;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlBean {

  @XmlElement
  public int age;
  @XmlElement
  public List<XmlBeanChild> goods;
  @XmlElement
  public String name;
  @XmlAttribute
  public int state;

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
