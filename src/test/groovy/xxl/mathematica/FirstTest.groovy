package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Function
import xxl.mathematica.list.Table
import xxl.mathematica.list.Take

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/5.
 */

class FirstTest {
    private class Student {
        String name = "default"

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
                student.name = String.valueOf(integer)
                return student
            }
        }, 0)
        System.out.print(First.first(list, new Student()).name)

    }

    @Test
    void name1() throws Exception {
        List<Student> list = Table.table(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.name = String.valueOf(integer)
                return student
            }
        }, 0)
        printList(list)
        printList(Take.take(list, -3))

    }

    @Test
    void name2() throws Exception {
        List<Student> list = Table.table(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.name = String.valueOf(integer)
                return student
            }
        }, 10)
        printList(list)
        printList(Take.take(list, -3))
    }

    @Test
    void name3() throws Exception {
        List<Student> list = Table.table(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.name = String.valueOf(integer)
                return student
            }
        }, 10)
        printList(list)
        printList(Take.take(list, -1, -5, -1))
    }
}