package xxl.mathematica.list

class UnionTest extends GroovyTestCase {

    void testUnion() {
        println(Union.union(["a", "b", "a", "c"], ["d", "a", "e", "b"]))
    }
}
