package xxl.mathematica.list

class SortTest extends GroovyTestCase {
    void testSort() {
        def list = [6, 4, 7, 3, 9, 4, 6, 8, 1, 2, 3]
        println(Sort.sort(list))
    }
}
