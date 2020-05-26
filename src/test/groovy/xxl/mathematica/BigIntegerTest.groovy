package xxl.mathematica

import org.junit.Test

/**
 * Created by zhang on 2017/9/14.
 */

class BigIntegerTest {
    @Test
    void name() throws Exception {
        System.out.println(new BigInteger("1/0", 10))
    }
}