package test;

/**
 * test
 * 在LeetCode上看到一道字节跳动在2020-6-20出的面试题
 * 给出一个字符串，每个字母都连续出现了2次并且这2次都是相邻的，只有一个字母出现了一次
 * 例子：aax
 * xaabb
 * aaxbb
 * x
 * 要求返回出现一次的那个字母
 * 特别要求时间复杂度小于O(n)
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/20 9:19 上午
 * @since 1.0
 */
public class Solution0620 {
    public static void main(String[] args) {
        System.out.println(check("aabbccddeex"));
        System.out.println(check("aax"));
        System.out.println(check("xaabb"));
        System.out.println(check("aaxbb"));
        System.out.println(check("aaxbb"));
        System.out.println(check("x"));
    }

    /**
     * 把"aaxbb"分解为[aa][xb][b]
     * 然后找到第一个不相邻的组[xb]，返回x
     *
     * @param s
     * @return
     */
    private static char check(String s) {
        int left = 0;
        int right = s.length() / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (s.charAt(2 * mid) == s.charAt(2 * mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return s.charAt(2 * left);
    }
}
