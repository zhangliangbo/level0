package xxl.mathematica.logic


import java.util.function.Predicate

class AllTrueTest extends GroovyTestCase {
    void testAllTrue() {
        def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        println(AllTrue.allTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t < 10
            }
        }))
        println(AllTrue.allTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t < 9
            }
        }))
    }
}
