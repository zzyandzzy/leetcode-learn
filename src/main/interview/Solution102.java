package main.interview;

/**
 * main.interview
 * 给定两个字符串 s1 和 s2，请编写一个程序，
 * 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/8 8:46 上午
 * @since 1.0
 */
public class Solution102 {
    public static void main(String[] args) {
        System.out.println(CheckPermutation("hhqhxjyrghjjsmduaxppwrqkikqnfdrzjowapehtbyrgrfyprrfrebzduxvvhhu",
                "jzvthzihsvghjhbrpfhdwixmyaxjrdzfvnhpmyrbqjpdffykqgahgzpjwvouurr"));
    }

    /**
     * 循环两遍解决
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        // 首先看看s1重排是否能够后构成s2
        // 实际上就是看s1里面的字符是不是包含s2
        if (isContains(s1, s2)) {
            return isContains(s2, s1);
        }
        return false;
    }

    private static boolean isContains(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            boolean isContain = false;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    isContain = true;
                    break;
                }
            }
            if (!isContain) {
                return false;
            }
        }
        return true;
    }
}
