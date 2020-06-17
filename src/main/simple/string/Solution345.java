package main.simple.string;

/**
 * main.simple.string
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/17 9:59 上午
 * @since 1.0
 */
public class Solution345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("a"));
        System.out.println(reverseVowels("ae"));
        System.out.println(reverseVowels(""));
        System.out.println(reverseVowels("eA"));
    }

    /**
     * 双指针，left指针从左往右读，遇到元音字母停止，
     * 并且right指针从右往左读，如果右边也遇到元音字母，则加入StringBuilder中,left++,right--
     * <p>
     * info
     * 解答成功:
     * 执行耗时:4 ms,击败了71.84% 的Java用户
     * 内存消耗:39.7 MB,击败了10.00% 的Java用户
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left <= right) {
            if (checkVowel(arr[left])) {
                if (checkVowel(arr[right])) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                }
                right--;
            } else if (checkVowel(arr[right])) {
                if (checkVowel(arr[left])) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    right--;
                }
                left++;
            } else {
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private static boolean checkVowel(char c) {
        return c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U';
    }
}
