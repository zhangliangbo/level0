package xxl.mathematica


import org.junit.Test
import xxl.mathematica.list.Drop
import xxl.mathematica.list.Table

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/5.
 */

class DropTest {
    private class Student {
        String name = "default"

        @Override
        String toString() {
            return name
        }
    }

    @Test
    void name1() throws Exception {
        List<Student> list = Table.table(
                {
                    integer ->
                        Student student = new Student()
                        student.name = String.valueOf(integer)
                        return student
                }, 10)
        printList(list)
        printList(Drop.drop(list, -3))
    }

    @Test
    void name2() throws Exception {
        List<Student> list = Table.table({
            integer ->
                Student student = new Student()
                student.name = String.valueOf(integer)
                return student
        }, 10)
        printList(list)
        printList(Drop.drop(list, 10))
    }

    @Test
    void name3() throws Exception {
        List<Student> list = Table.table({
            integer ->
                Student student = new Student()
                student.name = String.valueOf(integer)
                return student
        }, 10)
        printList(list)
        printList(Drop.drop(list, -5, -1))
    }

    @Test
    void name4() throws Exception {
        List<Student> list = Table.table({
            integer ->
                Student student = new Student()
                student.name = String.valueOf(integer)
                return student
        }, 10)
        printList(list)
        printList(Drop.drop(list, Arrays.asList(-1, -5, -1, 3, 6, 0)))
    }

}