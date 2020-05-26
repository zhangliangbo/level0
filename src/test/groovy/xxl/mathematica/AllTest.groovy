package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Function
import xxl.mathematica.list.Array
import xxl.mathematica.list.Count

import java.util.function.Predicate

import static xxl.mathematica.BaseTest.printList

/**
 * Created by zhang on 2017/9/11.
 */

class AllTest extends GroovyTestCase {

    class Student {
        int score
    }

    @Test
    void testName() {
        final List<Integer> score = RandomInteger.randomInteger(0, 100, 10)
        printList(score)
        List<Student> list = Array.array(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.score = score.get(integer)
                return student
            }
        }, 10)
        println("你们班都及格？ " + (AllTrue.allTrue(list, new Predicate<Student>() {
            @Override
            boolean test(Student student) {
                return student.score >= 60
            }
        }) ? "是" : "否"))

        println("你们班有一个及格？ " + (AnyTrue.anyTrue(list, new Predicate<Student>() {
            @Override
            boolean test(Student student) {
                return student.score >= 60
            }
        }) ? "是" : "否"))

        println("你们班有多少人及格？ " + (Count.count(list, new Predicate<Student>() {
            @Override
            boolean test(Student student) {
                return student.score >= 60
            }
        })))

        println("你们班没有人及格？ " + (NoneTrue.noneTrue(list, new Predicate<Student>() {
            @Override
            boolean test(Student student) {
                return student.score >= 60
            }
        }) ? "是" : "否"))
    }
}