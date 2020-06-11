package main.interview;

/**
 * main.interview
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * Related Topics
 * 字符串
 * 动态规划
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/11 10:15 上午
 * @since 1.0
 */
public class Solution0105 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pale", "int"));
        System.out.println(oneEditAway("pales", "pal"));
        System.out.println(oneEditAway("pales", "palss"));
    }

    /**
     * 插入和删除，直接判断字符串个数的变化还要判断字符串是否相等的情况
     * 但是替换字符没有字符串的个数的变化，需要找到替换的字符的个数
     * 替换的字符的个数大于1个则为多次编辑
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        if (len2 > len1) {
            return oneEditAway(second, first);
        }
        // 保持第一个比第二个长
        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                // 如果是长度相同字符串，那就比较下一个，如果长度不一样，那就从该字符开始进行比较。
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }
}
