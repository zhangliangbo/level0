package xxl.mathematica.string

class StringSplitTest extends GroovyTestCase {

    void testStringSplit() {
        assertEquals(["a", "b", "c", "d", "e", "f", "g"], StringSplit.stringSplit("a-b:c-d:e-f-g", [":", "-"]))
        assertEquals(["a-b:c-d:e-f-g"], StringSplit.stringSplit("a-b:c-d:e-f-g"))
    }


}