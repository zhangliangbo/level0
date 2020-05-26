package xxl.mathematica

import org.junit.Test

import static xxl.mathematica.BaseTest.printList
import static xxl.mathematica.list.Delete.delete

/**
 * Created by zhang on 2017/9/3.
 */

class DeleteTest {

    @Test
    void name2() throws Exception {
        printList(delete([1, 2, 3, 4, 5], 0))
        printList(delete([1, 2, 3, 4, 5], 1))
        printList(delete([1, 2, 3, 4, 5], 2))
        printList(delete([1, 2, 3, 4, 5], 3))
        printList(delete([1, 2, 3, 4, 5], 4))
        println("from end")
        printList(delete([1, 2, 3, 4, 5], -1))
        printList(delete([1, 2, 3, 4, 5], -2))
        printList(delete([1, 2, 3, 4, 5], -3))
        printList(delete([1, 2, 3, 4, 5], -4))
        printList(delete([1, 2, 3, 4, 5], -5))
        printList(delete([1, 2, 3, 4, 5], -6))
    }

    @Test
    void name3() throws Exception {
        printList(delete([1, 2, 3, 4, 5], []))
        printList(delete([1, 2, 3, 4, 5], [0]))
        printList(delete([1, 2, 3, 4, 5], [0, 1, 2]))
        printList(delete([1, 2, 3, 4, 5], [1, 3, 4]))
        printList(delete([1, 2, 3, 4, 5], [-1, -3, -4]))
    }
}