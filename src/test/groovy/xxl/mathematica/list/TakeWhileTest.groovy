package xxl.mathematica.list


import java.util.function.Predicate

class TakeWhileTest extends GroovyTestCase {
    void testTakeWhile() {
        println(TakeWhile.takeWhile([0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 3
            }
        }))
        println(TakeWhile.takeWhile([0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t <= 3
            }
        }))
    }
}
