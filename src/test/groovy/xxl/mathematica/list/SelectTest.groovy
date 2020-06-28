package xxl.mathematica.list


import java.util.function.Predicate

class SelectTest extends GroovyTestCase {
    void testSelect() {
        println(Select.select([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t > 5
            }
        }))
        println(Select.select([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
            @Override
            boolean test(Integer t) {
                return t <= 5
            }
        }))
    }
}
