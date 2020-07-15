package xxl.mathematica.io

import xxl.mathematica.external.Pojo
import xxl.mathematica.io.excel.IExcel

class ExportTest extends GroovyTestCase {
    void testExportXlsx() {
        println(Export.exportExcel(IExcel.JXL, "D:\\helloworld.xlsx", false, [[new Pojo("zlb", 18, "男")]]))
    }

    void testExportWord() {
        List<Object> content = new ArrayList<>()
        content.add("table 1")
        content.add([["c1", "c2", "c3"], ["aaa", "aa", "a"], ["aaa", "bbb", "ccc"]] as String[][])
        content.add("table2")
        content.add([["c1", "c2", "c3"], ["aaa", "bbb", "ccc"], ["aaa", "bbb", "ccc"]] as String[][])
        content.add("table3")
        content.add([["c1", "c2", "c3"], ["fff", "fff", "ff"], ["ggg", "ggg", "eee"]] as String[][])
        println(Export.exportWord("D:\\helloworld.doc", content))
    }

    void testExportText(){
        println(Export.exportText("D:\\a.txt","abcdefgh",false))
        println(Export.exportText("D:\\a.txt","123456789",true))
    }
}

