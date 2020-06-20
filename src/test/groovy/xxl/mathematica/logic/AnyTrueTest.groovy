package xxl.mathematica.logic

import java.util.function.Predicate

class AnyTrueTest extends GroovyTestCase {
    void testAnyTrue() {
        def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        println(AnyTrue.anyTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 1
            }
        }))
        println(AnyTrue.anyTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 8
            }
        }))
        println(AllTrue.allTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 9
            }
        }))
    }
}
