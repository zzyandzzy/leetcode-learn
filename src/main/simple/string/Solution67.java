package main.simple.string;

/**
 * main.simple.string
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/16 9:06 上午
 * @since 1.0
 */
public class Solution67 {
    public static void main(String[] args) {
        System.out.println(addBinary2("11", "1"));
        System.out.println(addBinary2("1010", "1011"));
        System.out.println(addBinary2("1010", "0"));
        System.out.println(addBinary2("0", "10010"));
        System.out.println(addBinary2("0", "0"));
        System.out.println(addBinary2("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "0"));
    }

    /**
     * 直接进行2进制相加
     * 1      1
     * 11     1
     * 1      11
     * <p>
     * info
     * 解答成功:
     * 执行耗时:3 ms,击败了56.01% 的Java用户
     * 内存消耗:38.6 MB,击败了7.69% 的Java用户
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
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

    /**
     * 先转成10进制相加后再转成2进制，失败
     * <p>
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        if (b == null || b.length() == 0) {
            return a;
        }
        int i = Integer.parseInt(a, 2);
        int j = Integer.parseInt(b, 2);
        int sum = i + j;
        if (sum == 0) {
            return "0";
        }
        // 再转二进制
        StringBuilder sb = new StringBuilder();
        while (sum > 0) {
            sb.append(sum % 2);
            sum /= 2;
        }
        sb.reverse();
        return sb.toString();
    }
}
