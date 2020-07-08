package xxl.mathematica

import org.junit.Test
import xxl.mathematica.list.Array

import java.util.function.BiFunction
import java.util.function.Function

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/4.
 */

class ArrayTest {
    @Test
    void name() throws Exception {
        List<Double> list = Array.array(new Function<Double, Double>() {
            @Override
            Double apply(Double d) {
                return d
            }
        } as Function<Integer, Object>, 10, 0)
        printList(list)
    }

    @Test
    void name1() throws Exception {
        List<List<Double>> list = Array.array(new BiFunction<Double, Double, Double>() {
            @Override
            Double apply(Double d1, Double d2) {
                return d1 + d2
            }
        }, 10, 10)
        printList(list)

    }
}