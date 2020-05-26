package xxl.mathematica

import org.junit.Test

import static xxl.mathematica.Xor.xor

/**
 * Created by zhang on 2017/9/11.
 */

class XorTest {
    @Test
    void name() throws Exception {
        System.out.println(xor(new Boolean[0]))
        System.out.println(xor(1 > 0, 0 > 1, 1 + 1 == 2))
        System.out.println(xor(1 + 1 == 2, 2 + 2 == 4))
        System.out.println(xor(1 + 1 == 2, 2 + 2 == 4, 4 + 4 == 8))
        System.out.println(xor(1 + 1 == 3, 2 + 2 == 3))
        System.out.println(xor((Boolean[]) null))
    }
}