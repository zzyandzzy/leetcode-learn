// id: 125
// title: 验证回文串
// slug: valid-palindrome
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                char c = (char) (s.charAt(i) + 32);
                sb.append(c);
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122
                    || s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                sb.append(s.charAt(i));
            }
        }
        // 再验证是否是回文字符串
        String str = sb.toString();
        int left = str.length() % 2 == 0 ? str.length() / 2 - 1 : str.length() / 2;
        int right = str.length() % 2 == 0 ? str.length() / 2 : str.length() / 2;
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left--;
                right++;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
