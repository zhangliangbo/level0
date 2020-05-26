package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Predicate
import xxl.mathematica.list.Range

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/5.
 */

class SelectFirstTest {
    @Test
    void name() throws Exception {
        List<Integer> origin = Range.range(100)
        printList(origin)
        System.out.println(SelectFirst.selectFirst(origin, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer > 98
            }
        }))
        System.out.println(SelectFirst.selectFirst(origin, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer > 100
            }
        }, -1))//选择前10个
    }
}