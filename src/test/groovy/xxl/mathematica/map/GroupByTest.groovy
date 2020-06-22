package xxl.mathematica.map


import java.util.function.Function

class GroupByTest extends GroovyTestCase {
    void testGroupBy() {
        println(GroupBy.groupBy([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], new Function<Integer, String>() {
            @Override
            String apply(Integer v) {
                return String.valueOf(v)
            }
        }))
    }
}
