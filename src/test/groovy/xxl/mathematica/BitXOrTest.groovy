package xxl.mathematica


import org.junit.Test

import static xxl.mathematica.BaseTest.printList
import static xxl.mathematica.BitXor.bitXor
import static xxl.mathematica.functional.Map.map

/**
 * Created by zhang on 2017/9/12.
 */

class BitXOrTest {
    @Test
    void name() throws Exception {
        printList(map({ Integer[] ints -> bitXor(ints) }, [[], [61], [61, 15], [61, 15, 13], [3333, 5555, 7777, 9999], [-61, 15]]))
    }
}