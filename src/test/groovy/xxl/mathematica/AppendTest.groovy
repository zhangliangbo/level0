package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Function

import static xxl.mathematica.BaseTest.printList
import static xxl.mathematica.NestList.nestList
import static xxl.mathematica.list.Append.append
import static xxl.mathematica.list.Prepend.prepend

/**
 * Created by zhang on 2017/9/3.
 */

class AppendTest {
    @Test
    void name() throws Exception {

        printList(nestList(new Function<List<Integer>, List<Integer>>() {
            @Override
            List<Integer> apply(List<Integer> list) {
                return append(list, 1)
            }
        }, Arrays.asList(5, 6), 5))
    }

    @Test
    void name2() throws Exception {

        printList(nestList(new Function<List<Integer>, List<Integer>>() {
            @Override
            List<Integer> apply(List<Integer> list) {
                return prepend(list, 1)
            }
        }, Arrays.asList(5, 6), 5))
    }
}