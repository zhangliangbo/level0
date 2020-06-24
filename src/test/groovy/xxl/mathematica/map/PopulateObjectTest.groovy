package xxl.mathematica.map

import xxl.mathematica.test.Hello

class PopulateObjectTest extends GroovyTestCase {
    void testPopulateObject() {
        def map = [name: "aaa", age: 1, info: "lllll", number: 5]
        println(PopulateObject.populateObject(map, Hello.class))
        Hello hello = new Hello()
        println(PopulateObject.populateObject(map, hello))
    }
}
