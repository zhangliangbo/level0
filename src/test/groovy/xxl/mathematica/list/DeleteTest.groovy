package xxl.mathematica.list
/**
 * Created by zhang on 2017/9/3.
 */

class DeleteTest extends GroovyTestCase {

    void testDelete() {
        println(Delete.delete(["a", "b", "c", "d"], [1, 3]))
    }
}