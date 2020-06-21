package xxl.mathematica.string

import org.apache.commons.text.matcher.StringMatcherFactory
import xxl.mathematica.io.Import

class StringCasesTest extends GroovyTestCase {
    void testStringCases() {
        println(StringCases.stringCases("the cat in the hat", "a.*e"))
        println(StringCases.stringCases("the cat in the hat", "a(.*)e", 1))
        println(StringCases.stringCases("abcdabcdcd", "abc|cd"))
    }
}
