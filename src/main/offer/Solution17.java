package main.offer;

import java.util.Arrays;

/**
 * main.offer
 * <p>
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/15 9:30 下午
 * @since 1.0
 */
public class Solution17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
        System.out.println(Arrays.toString(printNumbers(2)));
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 48.1 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int base = (int) Math.pow(10, n);
        int[] ret = new int[base - 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
