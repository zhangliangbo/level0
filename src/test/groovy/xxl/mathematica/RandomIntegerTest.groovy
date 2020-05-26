package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Function
import xxl.mathematica.function.Predicate
import xxl.mathematica.list.Table

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/10.
 */

class RandomIntegerTest {
    @Test
    void name() throws Exception {
        System.out.println(RandomInteger.randomInteger())
        printList(Table.table(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer integer) {
                return RandomInteger.randomInteger()
            }
        }, 100))
    }

    @Test
    void name4() throws Exception {
        System.out.println(RandomInteger.randomInteger())
        printList(Table.table(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer integer) {
                return RandomInteger.randomInteger(-10)
            }
        }, 100))
    }

    @Test
    void name5() throws Exception {
        System.out.println(RandomInteger.randomInteger())
        printList(Table.table(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer integer) {
                return RandomInteger.randomInteger(10)
            }
        }, 100))
    }

    @Test
    void name1() throws Exception {
        System.out.println(RandomInteger.randomInteger())
        List<Integer> list = Table.table(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer integer) {
                return RandomInteger.randomInteger(-10, 10)
            }
        }, 100)
        printList(list)
        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer <= -10
            }
        }))

        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer >= 10
            }
        }))
    }

    @Test
    void name2() throws Exception {
        System.out.println(RandomInteger.randomInteger())
        List<Integer> list = Table.table(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer integer) {
                return RandomInteger.randomInteger(10, -10)
            }
        }, 100)
        printList(list)
        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer >= 10
            }
        }))

        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer <= -10
            }
        }))
    }

    @Test
    void name3() throws Exception {
        System.out.println(RandomInteger.randomInteger())
        printList(Table.table(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer integer) {
                return RandomInteger.randomInteger(10, 10)
            }
        }, 100))
    }

    @Test
    void name6() throws Exception {
        List<Integer> list = RandomInteger.randomInteger(-10, 10, 100)
        printList(list)
        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer <= -10
            }
        }))

        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer >= 10
            }
        }))
    }

    @Test
    void name7() throws Exception {
        List<Integer> list = RandomInteger.randomInteger(10, -10, 100)
        printList(list)
        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer >= 10
            }
        }))

        printList(Select.select(list, new Predicate<Integer>() {
            @Override
            boolean test(Integer integer) {
                return integer <= -10
            }
        }))
    }

    @Test
    void name8() throws Exception {
        printList(RandomInteger.randomInteger(10, 10, 100))
    }
}