package xxl.mathematica

import xxl.mathematica.function.Function

/**
 * Created by zhang on 2017/9/1.
 */

class BaseTest {

    public static Function<Double, Double> newton3 = new Function<Double, Double>() {
        @Override
        Double apply(Double aDouble) {
            return 1D * (aDouble + 3D / aDouble) / 2D
        }
    }

    public static Function<Integer, Integer> divide2 = new Function<Integer, Integer>() {
        @Override
        Integer apply(Integer aDouble) {
            return aDouble / 2
        }
    }

    protected static void printList(List list) {
        System.out.println(Arrays.toString(list.toArray()))
    }
}