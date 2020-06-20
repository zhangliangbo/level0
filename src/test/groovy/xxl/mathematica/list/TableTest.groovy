package xxl.mathematica.list

import java.util.function.BiFunction
import java.util.function.Function


/**
 * Created by zhang on 2017/9/3.
 */

class TableTest extends GroovyTestCase {
    void testTable() {
        println(Table.table(new Function<Integer, String>() {
            @Override
            String apply(Integer t) {
                return "index" + t
            }
        }, Range.range(10)))

        println(Table.table(new BiFunction<Integer, Integer, String>() {
            @Override
            String apply(Integer f, Integer s) {
                return "(" + f + "," + s + ")"
            }
        }, Range.range(3), Range.range(3)))
    }

}