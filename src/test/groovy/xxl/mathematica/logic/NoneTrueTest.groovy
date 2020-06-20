package xxl.mathematica.logic

import java.util.function.Predicate

class NoneTrueTest extends GroovyTestCase {
    void testNoneTrue() {
        def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        println(NoneTrue.noneTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 1
            }
        }))
        println(NoneTrue.noneTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 8
            }
        }))
        println(NoneTrue.noneTrue(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 9
            }
        }))
    }
}
