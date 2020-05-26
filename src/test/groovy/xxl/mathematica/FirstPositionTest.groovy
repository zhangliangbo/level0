package xxl.mathematica


import org.junit.Test

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/10.
 */

class FirstPositionTest {

    @Test
    void name() throws Exception {
        List<Integer> list = RandomInteger.randomInteger(10, 20, 100)
        printList(list)
        int position = FirstPosition.firstPosition(list, { integer -> integer > 15 })
        println(position)
    }

    @Test
    void name1() throws Exception {
        List<Integer> list = RandomInteger.randomInteger(10, 20, 100)
        printList(list)
        int position = FirstPosition.firstPosition(list, { integer -> integer >= 20 }, -1)//取前5
        println(position)
    }
}