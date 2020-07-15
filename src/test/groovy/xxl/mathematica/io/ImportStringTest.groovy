package xxl.mathematica.io

import xxl.mathematica.test.Hello

class ImportStringTest extends GroovyTestCase {
    void testImportString() {
        XmlBean xmlBean = ImportString.importXml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xmlBean>\n" +
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

    void testImportStringXml() {
        Map map = ImportString.importXml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xmlBean>\n" +
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
                "</xmlBean>")
        println(map)
    }

    void testImportStringJson() {
        def map = ImportString.importJsonMapObject("{\n" +
                "    \"status\": \"0000\",\n" +
                "    \"message\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"title\": {\n" +
                "            \"id\": \"001\",\n" +
                "            \"name\" : \"白菜\"\n" +
                "        },\n" +
                "        \"content\": [\n" +
                "            {\n" +
                "                \"id\": \"001\",\n" +
                "                \"value\":\"你好 白菜\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"002\",\n" +
                "                 \"value\":\"你好 萝卜\" \n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n")
        println(map)
    }

    void testImportStringObject() {
        Hello hello = ImportString.importJsonObject("{\"name\":\"zlb\",\"age\":111,\"info\":\"some info\",\"number\":1}", Hello.class)
        println(hello)
    }

    void testImportStringMapString() {
        def map = ImportString.importJsonMapString("{\n" +
                "    \"status\": \"0000\",\n" +
                "    \"message\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"title\": {\n" +
                "            \"id\": \"001\",\n" +
                "            \"name\" : \"白菜\"\n" +
                "        },\n" +
                "        \"content\": [\n" +
                "            {\n" +
                "                \"id\": \"001\",\n" +
                "                \"value\":\"你好 白菜\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"002\",\n" +
                "                 \"value\":\"你好 萝卜\" \n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n")
        println(map)
    }
}
