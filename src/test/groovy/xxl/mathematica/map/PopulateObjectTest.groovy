package xxl.mathematica.map

import xxl.mathematica.test.Hello

class PopulateObjectTest extends GroovyTestCase {

    void testPopulateObject() {
        def map = [name: "aaa", age: 1, info: "lllll", number: 5]
        println(PopulateObject.populateObject(map, Hello.class))
    }

    void testPopulateObject1() {
        def map = [name: "aaa", age: 1, info: "lllll", number: 5]
        Hello hello = new Hello()
        println(PopulateObject.populateObject(map, hello))
    }

    void testPopulateObject2() {
        Hello src = new Hello()
        src.setName("xxl")
        src.setAge(111)
        src.setNumber(1)
        src.setInfo("hello world")
        println(PopulateObject.populateObject(src, Hello.class))
    }

    void testPopulateObject3() {
        Hello src = new Hello()
        src.setName("xxl")
        src.setAge(111)
        src.setNumber(1)
        src.setInfo("hello world")
        Hello dst = new Hello()
        println(PopulateObject.populateObject(src, dst))
    }


}
