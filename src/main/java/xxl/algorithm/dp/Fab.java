package xxl.algorithm.dp;

/**
 * @author zhangliangbo
 * @since 2022/5/21
 */
public class Fab {

    public static void main(String[] args) {
        System.out.println(fab(6));
    }

    static int fab(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int n_2 = 1;
        int n_1 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = n_1 + n_2;
            n_2 = n_1;
            n_1 = res;
        }
        return res;
    }

}
