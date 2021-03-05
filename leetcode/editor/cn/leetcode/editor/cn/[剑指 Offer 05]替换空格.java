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
        char[] data = new char[s.length() * 3];
        int size = 0;
        for (int i = 0, c = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                data[c++] = '%';
                data[c++] = '2';
                data[c++] = '0';
                size += 3;
            } else {
                data[c++] = s.charAt(i);
                size++;
            }
        }
        return new String(data, 0, size);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
