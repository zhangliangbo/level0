package xxl.mathematica.io

import org.junit.Test
import xxl.mathematica.io.ParentDirectory

/**
 * Created by zhang on 2017/9/22.
 */

class ParentDirectoryTest extends GroovyTestCase {

    void testParentDirectory() throws Exception {
        System.out.println(ParentDirectory.parentDirectory("C:\\Program Files\\abc.txt"))
        System.out.println(ParentDirectory.parentDirectory("C:\\Program Files"))
    }

}