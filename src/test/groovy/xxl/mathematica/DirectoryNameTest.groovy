package xxl.mathematica

import org.junit.Test

/**
 * Created by zhang on 2017/9/22.
 */

class DirectoryNameTest {
    @Test
    void name() throws Exception {
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 1))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 2))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 3))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 4))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 5))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 6))
        println("dir:" + DirectoryName.directoryName("a\\b\\c\\d.txt", 1))
        println("dir:" + DirectoryName.directoryName("a\\b\\c\\d.txt", 2))
        println("dir:" + DirectoryName.directoryName("a\\b\\c\\d.txt", 3))
        println("dir:" + DirectoryName.directoryName("a\\b\\c\\d.txt", 4))
        println("dir:" + DirectoryName.directoryName("a\\b\\c\\d.txt", 5))
        println("dir:" + DirectoryName.directoryName("\\a\\b\\c\\d.txt", 1))
        println("dir:" + DirectoryName.directoryName("\\a\\b\\c\\d.txt", 2))
        println("dir:" + DirectoryName.directoryName("\\a\\b\\c\\d.txt", 3))
        println("dir:" + DirectoryName.directoryName("\\a\\b\\c\\d.txt", 4))
        println("dir:" + DirectoryName.directoryName("\\a\\b\\c\\d.txt", 5))
        println("dir:" + DirectoryName.directoryName("C:\\Program Files\\"))
    }
}