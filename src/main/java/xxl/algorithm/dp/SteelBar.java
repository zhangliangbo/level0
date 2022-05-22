package xxl.algorithm.dp;

/**
 * @author zhangliangbo
 * @since 2022/5/22
 */
public class SteelBar {
    public static void main(String[] args) {
        int[] p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int q = cut(p, 4);
        System.out.println(q);
    }

    static int cut(int[] p, int n) {
        System.out.println("execute " + n);
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cut(p, n - i));
        }
        return q;
    }
}
