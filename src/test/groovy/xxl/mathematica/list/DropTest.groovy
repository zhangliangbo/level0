package xxl.mathematica.list
/**
 * Created by zhang on 2017/9/5.
 */

class DropTest extends GroovyTestCase {
    void testDrop() {
        def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        println(Drop.drop(list, 3))
        println(Drop.drop(list, 1, 7, 2))
        println(Drop.drop(list, 0, list.size()))
    }
}