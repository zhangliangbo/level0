package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.BiFunction

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/1.
 */

class FoldListTest<T> {
    @Test
    void name() throws Exception {
        //找出最大值
        List<Integer> list = FoldList.foldList(new BiFunction<Integer, Integer, Integer>() {
            @Override
            Integer apply(Integer a, Integer b) {
                return Math.max(a, b)
            }
        }, 0, [1, 3, 1, 2, 4, 1, 5, 3, 6, 2, 8, 11])
        printList(list)
    }

    @Test
    void name2() throws Exception {
        //列表的列表，嵌套列表
        List<List> list = FoldList.foldList(new BiFunction<List, List, List>() {
            @Override
            List apply(List list1, List list2) {
                List<List> lists = new ArrayList<>(0)
                lists.add(list1)
                lists.add(list2)
                return lists
            }
        }, [1, 2], [[3, 4], [5, 6], [7, 8]])
        printList(list)
    }

    @Test
    void name3() throws Exception {
        //列表的列表，嵌套列表
        List<List> list = FoldList.foldList(new BiFunction<List, List, List>() {
            @Override
            List apply(List list1, List list2) {
                List<List> lists = new ArrayList<>(0)
                lists.add(list1)
                lists.add(list2)
                return lists
            }
        }, [[1, 2]]) as List<List>
        printList(list)
    }
}