package xxl.mathematica.string

import xxl.mathematica.functional.Scan

import java.util.function.Function

class StringContainsQTest extends GroovyTestCase {
    void testStringContainQ() {
        Function<String, Boolean> function = StringContainsQ.stringContainQ("a.*")
        def list = ["a", "b", "ab", "abcd", "bcde"]
        Scan.scan({
            t ->
                println(t)
                println(function.apply(t))
        },
                list)
    }
}
