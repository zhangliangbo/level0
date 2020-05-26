package xxl.mathematica.io

class ExportStringTest extends GroovyTestCase {
    void testExportStringJson() {
        Map<String, String> map = new HashMap<>()
        map.put("a", "b")
        map.put("c", "d")
        map.put("e", "f")
        println(ExportString.exportStringJson(map))
    }

    void testExportStringXml() {
        XmlBean xmlBean = new XmlBean()
        xmlBean.name = "xxl"
        xmlBean.age = 18
        xmlBean.state = 12
        XmlBeanChild c1 = new XmlBeanChild();
        c1.name = "child1"
        c1.weight = 5
        XmlBeanChild c2 = new XmlBeanChild();
        c2.name = "child2"
        c2.weight = 10
        xmlBean.goods = [c1, c2]
        println(ExportString.exportStringXml(xmlBean))
    }
}
