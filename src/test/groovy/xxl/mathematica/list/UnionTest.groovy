package xxl.mathematica.list

class UnionTest extends GroovyTestCase {

    static def add(x, y) { return x + y }

    void testUnion() {
        println(Union.union(["a", "b", "a", "c"], ["d", "a", "e", "b"]))
        println(add(1, 1))
    }
}
