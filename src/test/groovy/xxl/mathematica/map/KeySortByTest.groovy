package xxl.mathematica.map


import java.util.function.Function

class KeySortByTest extends GroovyTestCase {
    void testKeySortBy() {
        println(KeySortBy.keySortBy([1: "a", 2: "b", 3: "c", 4: "d"], new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer k) {
                return -k
            }
        }))
    }
}
