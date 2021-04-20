package main.array;
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
// 👍 370 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/4/20 21:51
 * @since 1.0
 */
public class Solution125IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("aabba"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:2 ms,击败了99.87% 的Java用户
     * 内存消耗:38.5 MB,击败了69.69% 的Java用户
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int slow = 0;
        int high = s.length() - 1;
        while (slow < high) {
            char c1 = s.charAt(slow);
            char c2 = s.charAt(high);
            boolean b1 = isNum(c1);
            boolean b2 = isNum(c2);
            if (b1 && b2) {
                if (!checkChar(c1, c2)) {
                    return false;
                }
                slow++;
                high--;
            } else {
                if (!b1) {
                    slow++;
                }
                if (!b2) {
                    high--;
                }
            }
        }
        return true;
    }

    public static boolean checkChar(char c1, char c2) {
        if (c1 == c2) {
            return true;
        }
        if (c1 < '9' && c2 > 'A') {
            return false;
        }
        if (c1 > 'A' && c2 < '9') {
            return false;
        }
        return c1 > c2 ? c1 - 32 == c2 : c2 - 32 == c1;
    }

    private static boolean isNum(char c1) {
        return (c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z') || (c1 >= '0' && c1 <= '9');
    }
}
