package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Function
import xxl.mathematica.list.Table

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/5.
 */

class TakeDropTest {
    private class Student {

        String name = "default"

        @Override
        String toString() {
            return name
        }
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
        }, 10)
        printList(list)
        printList(TakeDrop.takeDrop(list, 3))
        printList(TakeDrop.takeDrop(list, -3))
        printList(TakeDrop.takeDrop(list, 3, 5))
        printList(TakeDrop.takeDrop(list, -1, -10, -2))
        printList(TakeDrop.takeDrop(list, 1, 10, 2))
    }
}