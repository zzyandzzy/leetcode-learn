package main.simple.string;

/**
 * main.simple.string
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/2 10:13 上午
 * @since 1.0
 */
public class Solution557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    /**
     * 执行用时：
     * 15 ms
     * , 在所有 Java 提交中击败了
     * 25.01%
     * 的用户
     * 内存消耗：
     * 40.2 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                if (i == s.length() - 1) {
                    temp.append(s.charAt(i));
                }
                temp.reverse();
                sb.append(temp);
                if (i != s.length() - 1) {
                    sb.append(' ');
                }
                temp.delete(0, temp.length());
            } else {
                temp.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
