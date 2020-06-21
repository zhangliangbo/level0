package xxl.mathematica.io


import xxl.mathematica.io.FileExtension

/**
 * Created by zhang on 2017/9/22.
 */

class FileExtensionTest extends GroovyTestCase {

    void testFileExtension() throws Exception {
        println(FileExtension.fileExtension("file.txt"))
        println(FileExtension.fileExtension("file.tar.gz"))
        println(FileExtension.fileExtension("C:\\file\\file\\file.tar.gz"))
        println(FileExtension.fileExtension("C:\\file\\file\\file.txt"))
    }
}