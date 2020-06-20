package xxl.mathematica.list
/**
 * Created by zhang on 2017/9/5.
 */

class TakeTest extends GroovyTestCase {
    void testTake() {
        def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        println(Take.take(list, 1, 7, 2))
        println(Take.take(list, 0, list.size()))
    }
}