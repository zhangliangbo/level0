package xxl.mathematica.list


/**
 * Created by zhang on 2017/9/10.
 */

class FirstPositionTest extends GroovyTestCase {

    void testFirstPosition() throws Exception {
        println(FirstPosition.firstPosition([1, 2, 3, 4, 5], { integer -> integer > 0 }))
        println(FirstPosition.firstPosition([1, 2, 3, 4, 5], { integer -> integer > 6 }, -1))
        println(FirstPosition.firstPosition([1, 2, 3, 4, 5], { integer -> integer > 6 }))
    }

}