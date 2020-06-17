// id: 22
// title: 括号生成
// slug: generate-parentheses
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        add(list, "(", n, 1);
        return list;
    }

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
//leetcode submit region end(Prohibit modification and deletion)
