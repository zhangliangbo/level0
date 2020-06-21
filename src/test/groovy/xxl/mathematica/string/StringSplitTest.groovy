package xxl.mathematica.string

class StringSplitTest extends GroovyTestCase {

    void testStringSplit() {
        println(StringSplit.stringSplit("a-b:c-d:e-f-g", ":", "-"))
    }


}