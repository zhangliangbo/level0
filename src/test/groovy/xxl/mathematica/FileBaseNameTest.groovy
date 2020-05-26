package xxl.mathematica

import org.junit.Test

/**
 * Created by zhang on 2017/9/22.
 */

class FileBaseNameTest {
    @Test
    void name() throws Exception {
        println(FileBaseName.fileBaseName("file"))
        println(FileBaseName.fileBaseName("file.tar.gz"))
        println(FileBaseName.fileBaseName("file."))
        println(FileBaseName.fileBaseName("file.txt"))
        println(FileBaseName.fileBaseName("file.txt"))
        println(FileBaseName.fileBaseName("C:\\Users\\zhang\\Rdrnss\\Code\\Flavors\\app\\release\\file.txt"))
        println(FileBaseName.fileBaseName(null))

    }
}