package xxl.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliangbo
 * @since 2021/11/10
 **/


@Slf4j
public class Anagram {

    public boolean isAnagramUseArr(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a']--;
        }
        return true;
    }

    public boolean isAnagramUseHash(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>(8);
        for (char c : s1.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }
            counts.put(c, counts.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.err.println(anagram.isAnagramUseHash("112233", "121212"));
    }

}
