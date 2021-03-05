package main.offer;

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

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/3/4 15:14
 * @since 1.0
 */
public class Solution05 {
    public static void main(String[] args) {
        System.out.println(replaceSpace3("We are happy."));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.5 MB,击败了19.63% 的Java用户
     *
     * @param s
     * @return
     */
    public static String replaceSpace3(String s) {
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

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.1 MB,击败了94.62% 的Java用户
     *
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {
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

    /**
     * 想也不想，直接for循环替换
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * <p>
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.8 MB,击败了99.86% 的Java用户
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 3);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
