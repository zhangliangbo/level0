package xxl.mathematica.external

import xxl.mathematica.RandomChoice
import xxl.mathematica.RandomInteger
import xxl.mathematica.list.Table
import xxl.mathematica.io.Export
import xxl.mathematica.io.excel.IExcel

class ExternalTest extends GroovyTestCase {
    void testExec() {
        println(new String(External.runProcess(new File("C:\\Users\\zhang\\Desktop\\file_server_main_jar"), 'mathematica.exe'), 'GBK'))
    }

    void testRun() {
        println(External.run('git --help'))
    }

    void testSendMail() {
        println(External.sendMail("forbidden@aliyun.com", "附件", "<img src=\"https://himg2.huanqiucdn.cn/attachment2010/2019/1101/20191101072831653.jpg\"/>", [new File("C:\\Users\\zhang\\Desktop\\shu.jpg")], "2472110501@qq.com", "smtp.aliyun.com", "forbidden@aliyun.com", "forbidden"))
    }

    void testIpConfig() {
        println(new String(External.runProcess("ipconfig /all")))
    }

    void testExportXlsx() {
        Export.exportXlsx(IExcel.POI, "C:\\Users\\zhang\\Desktop\\poi.xls",
                Table.table({ t ->
                    return new Pojo("姓名" + t, RandomInteger.randomInteger(100), null)
                }, 33),
                Table.table({ t ->
                    return new Pojo("姓名" + t, RandomInteger.randomInteger(100), RandomChoice.randomChoice(["男", "女"]))
                }, 55),
                Table.table({ t ->
                    return new Pojo("姓名" + t, RandomInteger.randomInteger(100), RandomChoice.randomChoice(["男", "女"]))
                }, 66))
    }

}
