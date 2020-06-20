package main.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author intent
 * @version 1.0
 * @date 2020/2/29 11:54 下午
 * @email zzy.main@gmail.com
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abbaacdf"));
    }

    /**
     * 暴力
     *
     * @param s
     * @return
     */
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; i++)
//            for (int j = i + 1; j <= n; j++)
//                for (int x = i; x < j; x++)
//                    if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
//        return ans;
//    }
//
//    private static boolean allUnique(String s, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i < end; i++) {
//            if (set.contains(s.charAt(i)))
//                return false;
//            set.add(s.charAt(i));
//        }
//        return true;
//    }


    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}