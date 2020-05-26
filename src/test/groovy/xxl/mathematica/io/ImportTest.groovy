package xxl.mathematica.io

import xxl.mathematica.external.Pojo
import xxl.mathematica.io.excel.IExcel

class ImportTest extends GroovyTestCase {
    void testImportExcel() {
        println(Import.importExcel(IExcel.JXL, "C:\\Users\\zhang\\Desktop\\helloworld.xlsx"))
    }

    void testImportExcelObject() {
        def obj = Import.importExcel(IExcel.POI, "C:\\Users\\zhang\\Desktop\\helloworld.xlsx", Pojo.class)
        println(obj)
    }
}
