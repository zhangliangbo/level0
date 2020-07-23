package xxl.mathematica.map

import xxl.mathematica.test.Hello

class ValuesTest extends GroovyTestCase {
    void testValues() {
        println(Values.values([1: "a", 2: "b", 3: "c", 4: "d", 5: "c"]))
    }

    void testTestValues() {
        Hello hello = new Hello()
        hello.setName("xxl")
        hello.setAge(111)
        hello.setNumber(1)
        hello.setInfo("hello world")
        println(Values.values(hello))
    }

    void testTestValues1() {
        Hello hello = new Hello()
        hello.setName("xxl")
        hello.setAge(111)
        hello.setNumber(1)
        hello.setInfo("hello world")
        println(Values.values(hello, ["name", "age"]))
    }
}
