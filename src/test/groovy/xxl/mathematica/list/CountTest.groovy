package xxl.mathematica.list

class CountTest extends GroovyTestCase {
    void testCount() {
        println(Count.count([1, 2, 3, 4, 5, 6, 7, 8, 9, 8], 8))
        println(Count.count([1, 2, 3, 4, 5, 6, 7, 8, 9, 8], 2))
    }
}
