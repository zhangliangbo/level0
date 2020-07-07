package xxl.mathematica.io

class FileExistsQTest extends GroovyTestCase {
    void testFileExistsQ() {
        println(FileExistsQ.fileExistsQ("C:\\a\\b\\c\\d"))
    }
}
