package xxl.mathematica.list


import java.util.function.Predicate

class TakeWhileTest extends GroovyTestCase {
    void testTakeWhile() {
        println(TakeWhile.takeWhile([1, 2, 3, 4, 5], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 3
            }
        }))
    }
}
