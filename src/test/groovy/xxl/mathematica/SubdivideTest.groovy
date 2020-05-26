package xxl.mathematica

import org.junit.Test

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/5.
 */

class SubdivideTest {
    @Test
    void name() throws Exception {
        printList(Subdivide.subdivide(100))
    }

    @Test
    void name1() throws Exception {
        printList(Subdivide.subdivide(-100, 100))
    }

    @Test
    void name2() throws Exception {
        printList(Subdivide.subdivide(-100, 100, 100))
    }
}