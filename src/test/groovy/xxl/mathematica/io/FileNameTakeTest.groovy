package xxl.mathematica.io

class FileNameTakeTest extends GroovyTestCase {
    void testFileNameTake() {
        println(FileNameTake.fileNameTake("D:\\a\\b\\c\\d\\e\\f\\g\\h", -1))//后1个
        println(FileNameTake.fileNameTake("D:\\a\\b\\c\\d\\e\\f\\g\\h", 1))//前1个
        println(FileNameTake.fileNameTake("D:\\a\\b\\c\\d\\e\\f\\g\\h", 1, 4))//从0开始的索引
    }
}
