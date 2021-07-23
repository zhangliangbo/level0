package xxl.mathematica.io

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.ExcelWriter
import com.alibaba.excel.metadata.Sheet
import com.alibaba.excel.metadata.Table
import com.alibaba.excel.support.ExcelTypeEnum
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder
import com.alibaba.excel.write.metadata.WriteSheet
import xxl.mathematica.external.Pojo
import xxl.mathematica.io.excel.IExcel

import java.util.function.IntFunction
import java.util.function.IntUnaryOperator
import java.util.stream.Collectors
import java.util.stream.IntStream

class ExportTest extends GroovyTestCase {
    void testExportXlsx() {
        println(Export.exportExcel(IExcel.JXL, "C:\\Users\\EDZ\\Desktop\\helloworld.xlsx", false, [[new Pojo("zlb", 18, "男")]]))
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

    void testExportText() {
        println(Export.exportText("D:\\a.txt", "abcdefgh", false))
        println(Export.exportText("D:\\a.txt", "123456789", true))
    }

    List<Pojo> data1() {
        return IntStream.range(0, 10)
                .mapToObj(new IntFunction<Pojo>() {
                    @Override
                    Pojo apply(int i) {
                        return new Pojo("zlb", i, "男")
                    }
                })
                .collect(Collectors.toList())
    }

    List<Pojo> data2() {
        return IntStream.range(1000, 2000)
                .mapToObj(new IntFunction<Pojo>() {
                    @Override
                    Pojo apply(int i) {
                        return new Pojo("zlb", i, "男")
                    }
                })
                .collect(Collectors.toList())
    }

    void testEasyExcel() {
        ExcelWriter excelWriter = EasyExcel.write("C:\\Users\\EDZ\\Desktop\\helloworld.xlsx", Pojo.class).build()
        WriteSheet writeSheet = new ExcelWriterSheetBuilder(excelWriter).sheetName("hhh").build()
        List<Pojo> data1 = data1()
        excelWriter.write(data1, writeSheet).write(data1, writeSheet)
        excelWriter.finish()
    }
}

