package xxl.mathematica

import xxl.mathematica.io.FileNames

class FileNamesTest extends GroovyTestCase {
    void testFileNames() {
        println(FileNames.fileNames(".*apk", "C:\\Users\\Admin\\Downloads"))
    }
}
