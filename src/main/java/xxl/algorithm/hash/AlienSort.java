package xxl.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

/**
 * 把字母表的字母及其位置映射到数组，通过数组下标获取位置，然后排序待排序字符串的第一个不同的字母
 *
 * @author zhangliangbo
 * @since 2021/11/12
 **/


@Slf4j
public class AlienSort {

    public boolean isAlienSort(String[] arr, String order) {

        char[] chars = order.toCharArray();
        int[] position = new int[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            position[c - 'a'] = i;
        }

        for (int i = 0; i < arr.length - 1; ++i) {
            char[] lc = arr[i].toCharArray();
            char[] rc = arr[i + 1].toCharArray();
            for (int j = 0; j < lc.length && j < rc.length; ++j) {
                int diff = position[lc[j] - 'a'] - position[rc[j] - 'a'];
                if (diff == 0) {
                    continue;
                }
                return diff < 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        AlienSort alienSort = new AlienSort();
        boolean sort = alienSort.isAlienSort(new String[]{"fsafsda", "fdsafs", "oworjqwfa"}, "zyxwvutsrqponmlkjihgfedcba");
        System.err.println(sort);
    }

}
