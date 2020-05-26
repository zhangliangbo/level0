package xxl.mathematica


import org.junit.Test
import xxl.mathematica.list.Table

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/6.
 */

class DeleteDuplicatesByTest {

    class Student {

        String name
        int score

        @Override
        String toString() {
            return name + score
        }
    }

    @Test
    void name() throws Exception {
        List<Student> studentList = Table.table({
            integer ->
                Student student = new Student()
                student.name = "学生党"
                student.score = integer
                student
        }, [1, 7, 8, 4, 3, 4, 1, 9, 9, 2])
        printList(studentList)
        List<Student> list = DeleteDuplicatesBy.deleteDuplicatesBy(studentList, { student -> student.score })
        printList(list)
    }
}