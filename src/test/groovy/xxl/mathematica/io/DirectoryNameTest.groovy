package xxl.mathematica.io

import org.junit.Test
import xxl.mathematica.io.DirectoryName

/**
 * Created by zhang on 2017/9/22.
 */

class DirectoryNameTest extends GroovyTestCase {

    void testDirectoryName() throws Exception {
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 0))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 1))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 2))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 3))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 4))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 5))
        println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 6))
    }
}