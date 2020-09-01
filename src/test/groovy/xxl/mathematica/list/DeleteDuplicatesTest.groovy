package xxl.mathematica.list

import org.junit.Test

import static xxl.mathematica.list.DeleteDuplicates.deleteDuplicates

/**
 * Created by zhang on 2017/9/6.
 */

class DeleteDuplicatesTest {

    @Test
    void name() throws Exception {
        println(deleteDuplicates([1, 7, 8, 4, 3, 4, 1, 9, 9, 2]))
    }

}