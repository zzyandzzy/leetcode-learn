package main.simple.string;

/**
 * main.simple.string
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/30 7:57 下午
 * @since 1.0
 */
public class Solution28 {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("", ""));// 0
        System.out.println(strStr("a", ""));// 0
        System.out.println(strStr("", "a"));// -1
    }

    /**
     * KMP
     * <p>
     * 执行用时：
     * 24 ms
     * , 在所有 Java 提交中击败了
     * 5.57%
     * 的用户
     * 内存消耗：
     * 69.7 MB
     * , 在所有 Java 提交中击败了
     * 5.43%
     * 的用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        // 构造KMP中的dp矩阵
        int m = needle.length();
        // 各个状态(行)遇到下一个字符(列)跳转到哪个状态
        int[][] dp = new int[m][256];
        // 影子状态
        int X = 0;
        dp[0][needle.charAt(0)] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 256; j++) {
                //假设下个字符不匹配，此时要回去看影子状态，从而得知跳转到哪个状态
                dp[i][j] = dp[X][j];
            }
            // 只有pat上i的字符匹配，跳转到下个状态
            dp[i][needle.charAt(i)] = i + 1;
            // 更新影子状态
            X = dp[X][needle.charAt(i)];
        }
        // 构造dp完成后，开始search
        // 初始状态为0
        int s = 0;
        for (int i = 0; i < haystack.length(); i++) {
            s = dp[s][haystack.charAt(i)];
            if (s == m) {
                return i - m + 1;
            }
        }
        // 匹配失败，返回-1
        return -1;
    }
}
