package xxl.mathematica

import org.junit.Test
import xxl.mathematica.list.Position

/**
 * Created by zhang on 2017/9/10.
 */

class PositionTest {
    @Test
    void name() throws Exception {
        println(Position.position([1, 2, 3, 2, 4, 2, 5, 2, 6, 2, 7, 2, 8, 2, 9], 2))
    }
}