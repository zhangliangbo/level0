package xxl.mathematica.list

import java.util.function.Predicate

class SelectFirstTest extends GroovyTestCase {
    void testSelectFirst() {
        println(SelectFirst.selectFirst([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 5;
            }
        }))
        println(SelectFirst.selectFirst([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t <= 5;
            }
        }))
    }
}
