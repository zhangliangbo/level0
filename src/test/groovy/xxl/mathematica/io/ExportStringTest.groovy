package xxl.mathematica.io

import xxl.mathematica.test.Hello

class ExportStringTest extends GroovyTestCase {

    void testExportStringJson() {
        Hello hello = new Hello()
        hello.setName("zlb")
        hello.setAge(111)
        hello.setInfo("some info")
        hello.setNumber(1)
        println(ExportString.exportStringJson(hello))
    }

    void testExportStringXml() {
        XmlBean xmlBean = new XmlBean()
        xmlBean.name = "xxl"
        xmlBean.age = 18
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
