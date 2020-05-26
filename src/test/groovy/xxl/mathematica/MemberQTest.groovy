package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.Function
import xxl.mathematica.function.Predicate
import xxl.mathematica.list.Array

/**
 * Created by zhang on 2017/9/10.
 */

class MemberQTest {

    class Student {
        String name
    }

    @Test
    void name() throws Exception {

        final List<String> names = Arrays.asList("张三", "李四", "王五")
        List<Student> studentList = Array.array(new Function<Integer, Student>() {
            @Override
            Student apply(Integer integer) {
                Student student = new Student()
                student.name = names.get(integer)
                return student
            }
        }, names.size())

        System.out.println("你们班有没有叫王五的? " +
                (AnyTrue.anyTrue(studentList, new Predicate<Student>() {
                    @Override
                    boolean test(Student student) {
                        return "王五".equals(student.name)
                    }
                }) ? "有" : "没有"))
    }


}