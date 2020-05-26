package xxl.mathematica.io

class ImportStringTest extends GroovyTestCase {
    void testImportString() {
        XmlBean xmlBean = ImportString.importStringXml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xmlBean state=\"12\">\n" +
                "    <name>xxl</name>\n" +
                "    <age>18</age>\n" +
                "    <goods>\n" +
                "        <name>child1</name>\n" +
                "        <weight>5</weight>\n" +
                "    </goods>\n" +
                "    <goods>\n" +
                "        <name>child2</name>\n" +
                "        <weight>10</weight>\n" +
                "    </goods>\n" +
                "</xmlBean>", XmlBean.class)
        println(xmlBean)
    }
}
