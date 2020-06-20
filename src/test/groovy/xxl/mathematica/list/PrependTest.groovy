package xxl.mathematica.list

class PrependTest extends GroovyTestCase {
    void testPrepend() {
        println(Prepend.prepend(["a", "b", "c", "d"], "head"))
    }
}
