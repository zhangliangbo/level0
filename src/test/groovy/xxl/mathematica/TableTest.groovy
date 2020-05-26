package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.BiFunction
import xxl.mathematica.function.Function
import xxl.mathematica.list.Table

import static xxl.mathematica.BaseTest.printList
import static xxl.mathematica.list.Range.range

/**
 * Created by zhang on 2017/9/3.
 */

class TableTest {

    class Student {
        String name

        @Override
        String toString() {
            return name
        }
    }

    @Test
    void name() throws Exception {

        List<Student> list = Table.table(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.name = "splitter" + integer
                return student
            }
        }, range(10))
        for (Student student : list) {
            System.out.println(student.name)
        }
    }

    @Test
    void name1() throws Exception {

        printList(Table.table(new BiFunction<Integer, Integer, Student>() {

            @Override
            Student apply(Integer integer, Integer integer2) {
                Student student = new Student()
                student.name = "splitter" + integer + "" + integer2
                return student
            }
        }, range(10), range(10)))
    }

    @Test
    void name2() throws Exception {

        List<Student> list = Table.table(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.name = "splitter" + integer
                return student
            }
        }, range(3, 100, 2))
        for (Student student : list) {
            System.out.println(student.name)
        }

    }

    @Test
    void name3() throws Exception {
        printList(Table.table(new BiFunction<Integer, Integer, Student>() {

            @Override
            Student apply(Integer integer, Integer integer2) {
                Student student = new Student()
                student.name = "splitter" + integer + "" + integer2
                return student
            }
        }, range(4, 8, 3), range(8, 11, 1)))

    }

    @Test
    void name4() throws Exception {
        printList(Table.table(new BiFunction<Integer, Integer, Student>() {
            @Override
            Student apply(Integer integer, Integer integer2) {
                Student student = new Student()
                student.name = "splitter" + integer + "" + integer2
                return student
            }
        }, Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6)))
    }
}