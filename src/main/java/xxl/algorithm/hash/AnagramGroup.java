package xxl.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;

/**
 * 变位词组
 *
 * @author zhangliangbo
 * @since 2021/11/11
 **/


@Slf4j
public class AnagramGroup {

    /**
     * 每个字符代表一个质数
     * 利用乘法的交换律
     */
    public List<List<String>> groupAnagramUseProduct(String[] arr) {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        Map<BigDecimal, List<String>> map = new HashMap<>(8);
        for (String s : arr) {
            BigDecimal product = BigDecimal.ONE;
            for (char c : s.toCharArray()) {
                product = product.multiply(BigDecimal.valueOf(primes[c - 'a']));
            }
            map.putIfAbsent(product, new LinkedList<>());
            map.get(product).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 变位词按字母序排序后是相同的
     */
    public List<List<String>> groupAnagramUseSort(String[] arr) {
        Map<String, List<String>> map = new HashMap<>(8);
        for (String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.putIfAbsent(sorted, new LinkedList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        AnagramGroup anagramGroup = new AnagramGroup();
        String[] data = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = anagramGroup.groupAnagramUseProduct(data);
        System.err.println(res);
        res = anagramGroup.groupAnagramUseSort(data);
        System.err.println(res);
    }

}
