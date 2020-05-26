package xxl.mathematica;

/**
 * 按位非
 */

public class BitNot {
    /**
     * 给出整数 n 按位的位非(NOT).
     *
     * @param integer
     * @return
     */
    public static int bitNot(Integer integer) {
        ObjectHelper.requireNonNull(integer);
        return ~integer;
    }
}
