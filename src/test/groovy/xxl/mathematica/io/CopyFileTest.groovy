package xxl.mathematica.io

class CopyFileTest extends GroovyTestCase {
    void testCopyFile() {
        println(CopyFile.copyFile("C:\\a.jar", "D:\\b.jar"))
    }
}
