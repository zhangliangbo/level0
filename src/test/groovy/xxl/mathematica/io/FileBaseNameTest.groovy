package xxl.mathematica.io


import xxl.mathematica.io.FileBaseName

/**
 * Created by zhang on 2017/9/22.
 */

class FileBaseNameTest extends GroovyTestCase {

    void testFileBaseName() throws Exception {
        println(FileBaseName.fileBaseName("first"))
        println(FileBaseName.fileBaseName("second.tar.gz"))
        println(FileBaseName.fileBaseName("three."))
        println(FileBaseName.fileBaseName("four.txt"))
        println(FileBaseName.fileBaseName("C:\\Users\\zhang\\Rdrnss\\Code\\Flavors\\app\\release\\five.txt"))
    }
}