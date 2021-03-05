//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 第一步：统计空格
        int blankLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                blankLen++;
            }
        }
        // 第二步：创建数组
        char[] data = new char[s.length() + blankLen * 2];
        int p2 = data.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                data[p2--] = '0';
                data[p2--] = '2';
                data[p2--] = '%';
            } else {
                data[p2--] = s.charAt(i);
            }
        }
        return new String(data);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
