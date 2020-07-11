package main.offer;

/**
 * main.offer
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 * <p>
 * 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/11 9:29 下午
 * @since 1.0
 */
public class Solution15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight2(Integer.parseUnsignedInt("00000000000000000000000000000000", 2)));
        System.out.println(hammingWeight2(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(hammingWeight2(Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(hammingWeight2(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
        System.out.println(hammingWeight2(Integer.parseUnsignedInt("11111111111111111111111111111111", 2)));
    }

    /**
     * 另外一种方法!!!
     *
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    /**
     * 转换成二进制再求1的个数虽然可以但是时间复杂度偏高
     * 肯定还有更好的方法！！！
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.26%
     * 的用户
     * 内存消耗：
     * 36.6 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        long x = n;
        if (x < 0) {
            x = 0xffffffffL + n + 1;
        }
        int count = 0;
        while (x > 0) {
            if (x % 2 == 1) {
                count++;
            }
            x = x / 2;
        }
        return count;
    }
}
