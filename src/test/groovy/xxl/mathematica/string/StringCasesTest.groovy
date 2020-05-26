package xxl.mathematica.string

import org.apache.commons.text.matcher.StringMatcherFactory
import xxl.mathematica.io.Import

class StringCasesTest extends GroovyTestCase {
    void testStringCases() {
        println(StringCases.stringCases("the cat in the hat", "a.*e"))
    }

    void testUseFile() {
        String file = Import.importText("D:\\xxlun\\xxlun\\netlogo\\20190921\\netlogo-vue\\src\\components\\Ask.vue")
        println(file)
        println(StringCases.stringCases(file, "\n"))
    }

    void test1() {
        println(StringCases.stringCases("abcdabcdcd", "abc|cd"))
    }

    void test2() {
        def matcher = StringMatcherFactory.INSTANCE.stringMatcher("abc")
        char[] buffer = "abcdef".toCharArray()
        println(matcher.isMatch(buffer, 1, 0, buffer.length))
    }
}
