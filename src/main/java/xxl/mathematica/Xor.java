package xxl.mathematica;

import static xxl.mathematica.predication.OddQ.oddQ;

/**
 * 逻辑异或
 */

public class Xor {
    /**
     * 是逻辑异或（XOR）函数. 如果奇数个 item 是 True，其余是 False，它给出 True. 如果偶数个 item 是 True，其余是 False，它给出 False.
     *
     * @param predicates
     * @return
     */
    public static boolean xor(Boolean... predicates) {
        ObjectHelper.requireNonNull(predicates, "predicates");
        int right = 0;
        for (boolean predicate : predicates) {
            if (predicate) {
                right++;
            }
        }
        return oddQ(right);
    }
}
