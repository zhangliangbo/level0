package xxl.algorithm.dp;

/**
 * @author zhangliangbo
 * @since 2022/5/22
 */
public class SteelBarMemoized {
    public static void main(String[] args) {
        int[] p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int num = 4;
        int[] cache = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            cache[i] = -1;
        }
        int q = cut(p, 4, cache);
        System.out.println(q);
    }

    static int cut(int[] p, int n, int[] cache) {
        if (cache[n] >= 0) {
            return cache[n];
        }
        System.out.println("execute " + n);
        if (n == 0) {
            cache[n] = 0;
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cut(p, n - i, cache));
        }
        cache[n] = q;
        return q;
    }
}
