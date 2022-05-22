package xxl.algorithm.dp;

/**
 * @author zhangliangbo
 * @since 2022/5/22
 */
public class SteelBarBottomUp {
    public static void main(String[] args) {
        int[] p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int q = cut(p, 8);
        System.out.println(q);
    }

    static int cut(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int[] stage = new int[n + 1];
        stage[0] = 0;
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j] + stage[i - j]);
            }
            stage[i] = q;
        }
        return stage[stage.length - 1];
    }

}
