package xxl.mathematica.string

class StringContainsQTest extends GroovyTestCase {
    void testStringContainQ() {
        println(StringContainsQ.stringContainsQ("abcdefghijk", "abc"))
        println(StringContainsQ.stringContainsQ("abcdefghijk", "abcc"))
    }
}
