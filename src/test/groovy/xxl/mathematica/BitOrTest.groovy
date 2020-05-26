package xxl.mathematica


import org.junit.Test

import static xxl.mathematica.BaseTest.printList
import static xxl.mathematica.BitOr.bitOr
import static xxl.mathematica.functional.Map.map

/**
 * Created by zhang on 2017/9/12.
 */

class BitOrTest {
    @Test
    void name() throws Exception {
        printList(map({ Integer[] ints -> bitOr(ints) }, [[], [61], [61, 15], [61, 15, 13], [3333, 5555, 7777, 9999]]))
    }


}