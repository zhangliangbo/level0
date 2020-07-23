package xxl.mathematica.map


import java.util.function.BiFunction

class KeyValueMapTest extends GroovyTestCase {
    void testKeyValueMap() {
        println(KeyValueMap.keyValueMap(new BiFunction<Integer, String, String>() {
            @Override
            String apply(Integer k, String v) {
                return k + v
            }
        }, [1: "a", 2: "b", 3: "c", 4: "b"]))
    }
}
