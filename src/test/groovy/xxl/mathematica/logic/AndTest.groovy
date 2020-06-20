package xxl.mathematica.logic
/**
 * Created by zhang on 2017/9/11.
 */

class AndTest extends GroovyTestCase {

    void testAnd() {
        println(And.and(1 > 0, 2 < 3, 5 < 6, true))
        println(And.and(1 > 0, 2 > 3, 5 < 6, true))
    }
}