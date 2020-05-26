package xxl.mathematica


import org.junit.Test

import static xxl.mathematica.BitShiftRight.bitShiftRight
import static xxl.mathematica.functional.Map.map

/**
 * Created by zhang on 2017/9/12.
 */

class BitShiftRightTest {
    @Test
    void name() throws Exception {
        println(map({ Integer[] integer -> bitShiftRight(integer[0], integer[1]) }, [[32, 3], [1, 2], [2, 2], [4, 2], [16, 2]]))

    }

    @Test
    void name1() throws Exception {
        println(map({ Integer[] integer -> Integer.rotateRight(integer[0], integer[1]) }, [[32, 3], [1, 2], [2, 2], [4, 2], [16, 2]]))
    }

    @Test
    void name3() throws Exception {
        println(new BigInteger("-1", 10))
    }

    @Test
    void name2() throws Exception {
        println(
                bitShiftRight(
                        new BigInteger("1606938044258990275541962092341162602522202993782792835301376", 10)
                                .add(new BigInteger("-1", 10)), 7))
        println("12554203470773361527671578846415332832204710888928069025791")

    }
}