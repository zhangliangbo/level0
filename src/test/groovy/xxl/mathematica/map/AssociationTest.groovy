package xxl.mathematica.map


import xxl.mathematica.Rule
import xxl.mathematica.test.Hello

class AssociationTest extends GroovyTestCase {

    void testAssociation() {
        def map = Association.association(Rule.valueOf("a", 1), Rule.valueOf("b", 2), Rule.valueOf("c", 3))
        println(map)
    }

    void testAssociation1() {
        Hello hello = new Hello()
        hello.setName("xxl")
        hello.setAge(18)
        hello.setInfo("info")
        hello.setNumber(2)
        def map = Association.association(hello)
        println(map)
    }
}
