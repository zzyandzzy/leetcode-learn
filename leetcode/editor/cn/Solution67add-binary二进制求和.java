// id: 67
// title: 二进制求和
// slug: add-binary
//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (b == null || b.length() == 0) {
            return a;
        }
        int length = Math.max(a.length(), b.length());
        // a和b的长度差
        int minLength = a.length() < b.length() ? (b.length() - a.length()) : a.length() - b.length();
        StringBuilder sb = new StringBuilder();
        // 进位
        int carry = 0;
        for (int i = length - 1; i >= 0; i--) {
            int sum = 0;
            if (a.length() == b.length()) {
                sum = a.charAt(i) + b.charAt(i) + carry - 96;
            } else if (a.length() > b.length()) {
                if (i - minLength >= 0) {
                    sum = a.charAt(i) + b.charAt(i - minLength) + carry - 96;
                } else {
                    sum = a.charAt(i) + carry - 48;
                }
            } else {
                if (i - minLength >= 0) {
                    sum = b.charAt(i) + a.charAt(i - minLength) + carry - 96;
                } else {
                    sum = b.charAt(i) + carry - 48;
                }
            }
            if (sum >= 2) {
                sb.append(sum - 2);
                carry = 1;
            } else {
                sb.append(sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
