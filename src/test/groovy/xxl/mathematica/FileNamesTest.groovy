package xxl.mathematica

class FileNamesTest extends GroovyTestCase {
    void testFileNames() {
        println(FileNames.fileNames(".*doc", "C:\\Users\\Admin\\Downloads"))
    }
}
