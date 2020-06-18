package main.other;

/**
 * main
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/4/17 12:41 下午
 * @since 1.0
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"acc", "aaa", "aaba"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 找出最短的那个字符串的长度
        int len = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
        }
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < temp.length() && j < len; j++) {
                if (temp.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            temp = temp.substring(0, j);
            if (temp.equals("")) return temp;
        }
        return temp;
    }
}
