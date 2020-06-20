package xxl.mathematica.logic
/**
 * Created by zhang on 2017/9/11.
 */

class NotTest extends GroovyTestCase {

    void testNot() throws Exception {
        println(Not.not(1 + 1 == 2))
        println(Not.not(Not.not(1 + 1 == 2)))//双重否定等于肯定
    }
}