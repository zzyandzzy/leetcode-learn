package main.interview;

/**
 * main.interview
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/15 4:07 下午
 * @since 1.0
 */
public class Solution0106 {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abbccd"));
        System.out.println(compressString("AAABbbbbCCCbbbDDfff"));
        System.out.println(compressString(""));
        System.out.println(compressString("bb"));
    }

    /**
     * 双重循环，一层管理整个字符串
     * 一层管理当前字符串之后有多少个相同的字符串
     *
     * @param S
     * @return
     */
    public static String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            // 当前的字符
            char currentChar = S.charAt(i);
            int currentCount = 1;
            for (int j = i + 1; j < S.length(); j++) {
                if (currentChar != S.charAt(j)) {
                    break;
                } else {
                    currentCount++;
                    i++;
                }
            }
            sb.append(currentChar).append(currentCount);
        }
        String ret = sb.toString();
        return ret.length() >= S.length() ? S : ret;
    }
}
