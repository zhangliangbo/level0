package xxl.mathematica.map

import java.util.function.Predicate

class KeySelectTest extends GroovyTestCase {
    void testKeySelect() {
        println(KeySelect.keySelect([1: "a", 2: "b", 3: "c", 4: "d", 5: "e"], new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer > 3
            }
        }))
    }
}
