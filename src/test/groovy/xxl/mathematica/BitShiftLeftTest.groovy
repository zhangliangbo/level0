package xxl.mathematica

import org.junit.Test

import static xxl.mathematica.BitShiftLeft.bitShiftLeft
import static xxl.mathematica.functional.Map.map

/**
 * Created by zhang on 2017/9/12.
 */

class BitShiftLeftTest {
    @Test
    void name() throws Exception {
        println(map({ Integer[] integer -> bitShiftLeft(integer[0], integer[1]) }, [[32, 3], [1, 2], [2, 2], [4, 2], [16, 2]]))
    }

    @Test
    void name1() throws Exception {
        println(map({ Integer[] integer -> Integer.rotateLeft(integer[0], integer[1]) }, [[32, 3], [1, 2], [2, 2], [4, 2], [16, 2]]))
    }

    @Test
    void name2() throws Exception {
        println(bitShiftLeft(
                new BigInteger("1606938044258990275541962092341162602522202993782792835301376", 10)
                        .add(new BigInteger("-1", 10)), 7))
        println("205688069665150755269371147819668813122841983204197482918576000")
    }
}