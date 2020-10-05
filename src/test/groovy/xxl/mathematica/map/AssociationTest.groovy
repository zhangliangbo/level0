package xxl.mathematica.map


import xxl.mathematica.Rule
import xxl.mathematica.test.Hello
import xxl.mathematica.test.Interest

class AssociationTest extends GroovyTestCase {

    void testAssociation() {
        def map = Association.ofRules(Rule.valueOf("a", 1), Rule.valueOf("b", 2), Rule.valueOf("c", 3))
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

    void testAssociation2() {
        Hello hello = new Hello()
        hello.setName("xxl")
        hello.setAge(18)
        hello.setInfo("info")
        hello.setNumber(2)
        def map = Association.association(hello, Interest.class)
        println(map)
    }

    void testAssociation3() {
        Hello hello = new Hello()
        hello.setName("xxl")
        hello.setAge(18)
        hello.setInfo("info")
        hello.setNumber(2)
        def map = Association.association(hello, ["name", "age"])
        println(map)
    }

}
