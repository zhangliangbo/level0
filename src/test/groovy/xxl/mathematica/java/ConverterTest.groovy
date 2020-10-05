package xxl.mathematica.java

import xxl.mathematica.Rule
import xxl.mathematica.map.Association

class ConverterTest extends GroovyTestCase {
    void testMap() {
        println(Converter.map(Association.ofRules(Rule.valueOf("a", "b"), Rule.valueOf("c", "d"))))
    }
}
