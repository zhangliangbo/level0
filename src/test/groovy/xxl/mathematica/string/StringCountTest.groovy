package xxl.mathematica.string

class StringCountTest extends GroovyTestCase {

    void testStringCount() {
        println(StringCount.stringCount("abc11abc22abc33abc44abc55", "abc"))
    }
}
