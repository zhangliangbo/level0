package xxl.mathematica.logic


import static xxl.mathematica.logic.Or.or

/**
 * Created by zhang on 2017/9/11.
 */

class OrTest extends GroovyTestCase {

    void testOr() {
        println(or(1 > 0, 0 > 1, 1 + 1 == 2))
        println(or(1 + 1 == 2, 2 + 2 == 4))
        println(or(1 + 1 == 3, 2 + 2 == 3))
    }
}