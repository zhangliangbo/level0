package xxl.mathematica.predication


import xxl.mathematica.predication.FreeQ

/**
 * Created by zhang on 2017/9/10.
 */

class FreeQTest extends GroovyTestCase {
    void testFreeQ() {
        println(FreeQ.freeQ([1, 2, 3, 4, 5], 5))
        println(FreeQ.freeQ([1, 2, 3, 4, 5], 6))
    }
}