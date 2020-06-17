package xxl.mathematica

import xxl.mathematica.map.KeySort

class KeySortTest extends GroovyTestCase {
    void testKeySort() {
        println(KeySort.keySort(["b": "y", "c": "z", "a": "x"]))
    }
}
