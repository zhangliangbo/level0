package xxl.mathematica

import org.junit.Test

import static xxl.mathematica.And.and

/**
 * Created by zhang on 2017/9/11.
 */

class AndTest {
    @Test
    void name() throws Exception {
        println(and(new Boolean[0]))
        println(and(1 > 0, 0 > 1, 1 + 1 == 2))
        println(and(1 + 1 == 2, 2 + 2 == 4))
        println(and(1 + 1 == 3, 2 + 2 == 3))
        println(and((Boolean[]) null))
    }
}