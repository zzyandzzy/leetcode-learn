package main.simple.string;

/**
 * main.simple.string
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/16 9:55 上午
 * @since 1.0
 */
public class Solution125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("abc12321cba"));
        System.out.println(isPalindrome("abc123321cba"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome("ab"));
    }

    /**
     * 先得到只包含字母和数字的字符串
     * 再验证是否是回文字符串
     * info
     * 解答成功:
     * 执行耗时:4 ms,击败了70.71% 的Java用户
     * 内存消耗:39.7 MB,击败了7.14% 的Java用户
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
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
