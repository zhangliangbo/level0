package xxl.mathematica

import org.junit.Test
import xxl.mathematica.io.ParentDirectory

/**
 * Created by zhang on 2017/9/22.
 */

class ParentDirectoryTest {
    @Test
    void name() throws Exception {

        System.out.println(ParentDirectory.parentDirectory("C:\\Program Files\\"))
    }

    @Test
    void name1() throws Exception {
        File file = new File("")
        System.out.println(file.getAbsolutePath())
    }
}