package xxl.mathematica

import org.junit.Test

import xxl.mathematica.functional.Map

import java.util.function.Function

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/11.
 */

class MapTest {
    @Test
    void name() throws Exception {
        List<Double> list = Map.map(new Function<Integer, Double>() {
            @Override
            Double apply(Integer integer) {
                return Math.pow(integer, 2)
            }
        }, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))
        printList(list)
    }
}