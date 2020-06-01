package xxl.mathematica

import xxl.mathematica.io.FileNames

class FileNamesTest extends GroovyTestCase {
    void testFileNames() {
        println(FileNames.fileNames(".*doc", "C:\\Users\\Admin\\Downloads"))
    }
}
