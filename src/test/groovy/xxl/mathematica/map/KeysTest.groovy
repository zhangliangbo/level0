package xxl.mathematica.map

import xxl.mathematica.test.Hello

class KeysTest extends GroovyTestCase {
    void testKeys() {
        println(Keys.keys(["a": 1, "b": 2, "c": 3, "d": 4, "e": 5]))
    }

    void testKeys1() {
        Hello hello = new Hello()
        hello.setName("xxl")
        hello.setAge(111)
        hello.setNumber(1)
        hello.setInfo("hello world")
        println(Keys.keys(hello))
    }

    void testKeys2() {
        println(Keys.keys(Hello.class))
    }
}
