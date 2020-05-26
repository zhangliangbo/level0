package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Predicate
import xxl.mathematica.list.Range

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/5.
 */

class SelectTest {
    @Test
    void name() throws Exception {
        List<Integer> origin = Range.range(100)
        printList(origin)
        printList(Select.select(origin, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer > 10
            }
        }))
        printList(Select.select(origin, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer > 10
            }
        }, 10))//选择前10个
    }
}