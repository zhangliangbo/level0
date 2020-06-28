package xxl.mathematica.string

import xxl.mathematica.functional.Scan

import java.util.function.Function

class StringContainsQTest extends GroovyTestCase {
    void testStringContainQ() {
        println(StringContainsQ.stringContainsQ("abcdefghijk", "abc"))
        println(StringContainsQ.stringContainsQ("abcdefghijk", "abcc"))
    }
}
