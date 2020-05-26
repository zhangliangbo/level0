package xxl.mathematica

import org.junit.Test
import xxl.mathematica.function.BiPredicate
import xxl.mathematica.function.Function

import static xxl.mathematica.BaseTest.newton3

/**
 * Created by zhang on 2017/8/27.
 */

class FixedPointTest {
    @Test
    void name1() throws Exception {
        double d = FixedPoint.fixPoint(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2
            }
        }, 1D, new BiPredicate<Double, Double>() {
            @Override
            boolean test(Double aDouble, Double aDouble2) {
                return Math.abs(aDouble - aDouble2) < 10e-3
            }
        })
        System.out.println(d)
    }

    class Student {
        double num
    }

    @Test
    void name2() throws Exception {
        Student start = new Student()
        start.num = 1D
        Student student = FixedPoint.fixPoint(new Function<Student, Student>() {
            @Override
            Student apply(Student student) {
                Student out = new Student()
                out.num = (student.num + 2D / student.num) / 2D
                return out
            }
        }, start, new BiPredicate<Student, Student>() {
            @Override
            boolean test(Student student, Student student2) {
                return Math.abs(student.num - student2.num) < 10e-3
            }
        })
        System.out.println("final student: " + student.num)
    }

    @Test
    void name3() throws Exception {
        double d = FixedPoint.fixPoint(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2
            }
        }, 1D, new BiPredicate<Double, Double>() {
            @Override
            boolean test(Double aDouble, Double aDouble2) {
                return Math.abs(aDouble - aDouble2) < 10e-3
            }
        }, 2)
        System.out.println(d)

    }

    @Test
    void name4() throws Exception {
        List<Double> list = FixedPointList.fixPointList(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2
            }
        }, 1D, new BiPredicate<Double, Double>() {
            @Override
            boolean test(Double aDouble, Double aDouble2) {
                return Math.abs(aDouble - aDouble2) < 10e-3
            }
        }, 2)
        System.out.print(Arrays.toString(list.toArray()))
    }

    @Test
    void name5() throws Exception {
        List<Double> list = FixedPointList.fixPointList(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2
            }
        }, 1D, new BiPredicate<Double, Double>() {
            @Override
            boolean test(Double aDouble, Double aDouble2) {
                return Math.abs(aDouble - aDouble2) < 10e-8
            }
        })
        System.out.print(Arrays.toString(list.toArray()))
    }

    @Test
    void name6() throws Exception {
        double d = FixedPoint.fixPoint(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2
            }
        }, 1D, 10e-8)
        System.out.println(d)
    }

    @Test
    void name7() throws Exception {

        List<Double> list = FixedPointList.fixPointList(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2
            }
        }, 1D, 10e-15)
        System.out.print(Arrays.toString(list.toArray()))
    }

    @Test
    void name8() throws Exception {
        List<Double> list = FixedPointList.fixPointList(newton3, 1D)
        System.out.println(Arrays.toString(list.toArray()))
    }
}