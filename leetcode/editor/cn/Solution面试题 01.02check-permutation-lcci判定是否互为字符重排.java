// id: 面试题 01.02
// title: 判定是否互为字符重排
// slug: check-permutation-lcci
//给定两个字符串 s1 和 s2，请编写一个程序，
// 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        // 首先看看s1重排是否能够后构成s2
        // 实际上就是看s1里面的字符是不是包含s2
        if (isContains(s1, s2)) {
            return isContains(s2, s1);
        }
        return false;
    }

    public boolean isContains(String s1, String s2) {
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
//leetcode submit region end(Prohibit modification and deletion)
