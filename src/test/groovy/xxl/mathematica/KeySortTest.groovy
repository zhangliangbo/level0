package xxl.mathematica

import xxl.mathematica.map.KeySort

class KeySortTest extends GroovyTestCase {
    void testKeySort() {
        println(KeySort.keySort(["b": 1, "c": 2, "a": 3]))
    }
}
