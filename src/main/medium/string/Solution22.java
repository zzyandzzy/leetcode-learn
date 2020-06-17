package main.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * main.medium.string
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/17 9:34 上午
 * @since 1.0
 */
public class Solution22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }

    /**
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        add(list, "(", n, 1);
        return list;
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:1 ms,击败了97.42% 的Java用户
     * 内存消耗:39.9 MB,击败了5.26% 的Java用户
     *
     * @param list
     * @param text
     * @param n
     * @param n1
     */
    public static void add(List<String> list, String text, int n, int n1) {
        if (text.length() == n * 2) {
            list.add(text);
            return;
        }

        if (n1 < n) {
            add(list, text + "(", n, n1 + 1);
        }
        if (n1 > text.length() / 2) {
            add(list, text + ")", n, n1);
        }
    }
}
