package cool.zzy.expore.array;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
//输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 👍 149 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/4/20 22:34
 * @since 1.0
 */
public class Solution345ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("aeiou"));
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("a"));
        System.out.println(reverseVowels("ae"));
        System.out.println(reverseVowels(""));
        System.out.println(reverseVowels("eA"));
    }

    public static final char[] PATTERN = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    /**
     * 双指针
     * 解答成功:
     * 执行耗时:3 ms,击败了89.59% 的Java用户
     * 内存消耗:38.3 MB,击败了91.85% 的Java用户
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (isVowel(chars[left])) {
                if (isVowel(chars[right])) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                }
                right--;
            } else if (isVowel(chars[right])) {
                if (isVowel(chars[left])) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    right--;
                }
                left++;
            } else {
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static boolean isVowel(char c) {
        for (char value : PATTERN) {
            if (c == value) {
                return true;
            }
        }
        return false;
    }

}
