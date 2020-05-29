package xxl.mathematica.predication;

/**
 * 素数判定
 */

public class PrimerQ {
    /**
     * 是否为素数
     *
     * @param number
     * @return
     */
    public static boolean primerQ(int number) {
        boolean flag = true;
        if (number < 2) {// 素数不小于2
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {// 若能被整除，则说明不是素数，返回false
                    flag = false;
                    break;// 跳出循环
                }
            }
        }
        return flag;
    }
}
