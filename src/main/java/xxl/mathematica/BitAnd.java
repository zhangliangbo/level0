package xxl.mathematica;

/**
 * 按位与
 */

public class BitAnd {
    /**
     * 给出整数的按位与(AND).
     *
     * @param ints
     * @return
     */
    public static int bitAnd(Integer... ints) {
        ObjectHelper.requireNonNull((Object) ints);
        if (ints.length == 0) {
            return -1;
        } else if (ints.length == 1) {
            return ints[0];
        } else {
            int result = ints[0];
            for (int i = 1; i < ints.length; i++) {
                result &= ints[i];
            }
            return result;
        }
    }
}
