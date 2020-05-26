package xxl.mathematica

import org.junit.Test

/**
 * Created by zhang on 2017/9/22.
 */

class FileExtensionTest {
    @Test
    void name() throws Exception {
        println("ext:" + FileExtension.fileExtension("file"))
        println("ext:" + FileExtension.fileExtension("file."))
        println("ext:" + FileExtension.fileExtension("file.txt"))
        println("ext:" + FileExtension.fileExtension("file.tar.gz"))
        println("ext:" + FileExtension.fileExtension("C:\\file\\file\\file.tar.gz"))
        println("ext:" + FileExtension.fileExtension("C:\\file\\file\\file.txt"))
        println("ext:" + FileExtension.fileExtension("C:\\file\\file\\file"))
        println("ext:" + FileExtension.fileExtension(null))
    }
}