package main.interview;

/**
 * main.interview
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/8 8:32 上午
 * @since 1.0
 */
public class Solution101 {
    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("intent"));
        System.out.println(isUnique("zzy"));
    }

    /**
     * 反手就是暴力循环
     *
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
