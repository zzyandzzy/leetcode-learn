package main;

/**
 * @author intent
 * @version 1.0
 * @date 2020/3/3 8:38 下午
 * @email zzy.main@gmail.com
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution8 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(0));
//        System.out.println(isPalindrome(1));
//        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
//        System.out.println(isPalindrome(-121));
//        System.out.println(isPalindrome(-10));
    }

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        // 从中间往两边扩展，中间有两种情况，比如1221和12321，一种有两个中心，一种只有一个中心
        // 可能有两个中心
        int center = str.length() / 2;
        int r = center;
        int l = center;
        if (str.length() % 2 == 0) {
            l = center - 1;
        }
        // 扩展
        for (int i = 0; i < center; i++) {
            if (str.charAt(--r) != str.charAt(++l)) {
                return false;
            }
        }
        return true;
    }
}
