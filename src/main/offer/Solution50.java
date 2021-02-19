package main.offer;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例:
//
// s = "abaccdeff"
//返回 "b"
//
//s = ""
//返回 " "
//
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 50000
// Related Topics 哈希表
// 👍 72 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/2/18 20:48
 * @since 1.0
 */
public class Solution50 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar(""));
    }

    /**
     * 解答成功:
     * 执行耗时:28 ms,击败了40.02% 的Java用户
     * 内存消耗:38.7 MB,击败了64.70% 的Java用户
     *
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>(32);
        char[] sc = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map.put(sc[i], !map.containsKey(sc[i]));
        }
        for (char c : sc) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 我滴个天，题目说是第一次仅出现一次的字符。。。
     *
     * @param s 字符串
     * @return 第一个只出现仅一次的字符
     */
    public static char firstUniqChar2(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int n = num[s.charAt(i) - 'a'];
            num[s.charAt(i) - 'a'] = ++n;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
}
