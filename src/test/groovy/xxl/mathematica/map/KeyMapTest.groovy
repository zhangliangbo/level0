package xxl.mathematica.map

import xxl.mathematica.function.Function

class KeyMapTest extends GroovyTestCase {
    void testKeyMap() {
        println(KeyMap.keyMap(new Function<Integer, String>() {
            @Override
            String apply(Integer k1) {
                return Math.pow(k1, 2)
            }
        }, [1: "a", 2: "b", 3: "c", 4: "d"]))
    }
}
