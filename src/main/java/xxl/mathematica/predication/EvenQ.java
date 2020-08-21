package xxl.mathematica.predication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 偶数判定
 */

public class EvenQ {
    /**
     * 是否为偶数
     *
     * @param number
     * @return
     */
    public static boolean evenQ(int number) {
        return number % 2 == 0;
    }
}
