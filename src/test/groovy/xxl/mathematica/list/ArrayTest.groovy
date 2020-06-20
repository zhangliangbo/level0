package xxl.mathematica.list

import xxl.mathematica.function.Function

class ArrayTest extends GroovyTestCase {
    void testArray() {
        println(Array.array(new Function<Integer, Character>() {
            @Override
            Character apply(Integer integer) {
                return integer as char
            }
        }, 26, 97))
    }
}
