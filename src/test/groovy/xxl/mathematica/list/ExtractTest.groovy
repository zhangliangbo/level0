package xxl.mathematica.list

class ExtractTest extends GroovyTestCase {
    void testExtract() {
        println(Extract.extract(["a", "b", "c", "d"], [0, 1]))
    }
}
