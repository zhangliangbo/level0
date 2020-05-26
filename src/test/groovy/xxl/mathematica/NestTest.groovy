package xxl.mathematica

import org.junit.Test
import xxl.mathematica.functional.Nest

import java.util.function.Function

import static xxl.mathematica.BaseTest.newton3

/**
 * Created by zhang on 2017/8/27.
 */

class NestTest {
    @Test
    void name1() throws Exception {
        double d = Nest.nest(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (1 + aDouble) * (1 + aDouble)
            }
        }, 1D, 3)
        System.out.println(d)
    }

    @Test
    void name2() throws Exception {
        double d = Nest.nest({ aDouble -> Math.sqrt(aDouble) }, 100, 4) as double
        System.out.println(d)
    }

    @Test
    void name3() throws Exception {
        double d = Nest.nest(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                if (aDouble > 10e6) {
                    System.out.println(aDouble)
                    return aDouble
                } else {
                    return aDouble * aDouble
                }
            }
        }, 2D, 6)
        println(d)
    }

    @Test
    void name4() throws Exception {
        List<Double> d = NestList.nestList(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return Math.sqrt(aDouble)
            }
        }, 100 as double, 4)
        System.out.println(Arrays.toString(d.toArray()))
    }

    @Test
    void name5() throws Exception {
        //在 10 年内每年复合资本的增长：
        double d = Nest.nest(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (1 + 0.05) * aDouble
            }
        }, 1000 as double, 10)
        System.out.println(d)
    }

    @Test
    void name6() throws Exception {
        //根号2的牛顿法迭代
        double d = Nest.nest(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return (aDouble + 2D / aDouble) / 2D
            }
        }, 1 as double, 5)
        System.out.println(d)
    }


    @Test
    void name8() throws Exception {
        List<Double> list = NestList.nestList(newton3, 1D, 5)
        System.out.println(Arrays.toString(list.toArray()))
    }
}