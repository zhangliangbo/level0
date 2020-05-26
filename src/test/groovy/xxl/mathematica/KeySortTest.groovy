package xxl.mathematica

class KeySortTest extends GroovyTestCase {
    void testKeySort() {
        println(KeySort.keySort(["b": "y", "c": "z", "a": "x"]))
    }
}
