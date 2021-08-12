package redo_2021_7_12.offer;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
//
//
//
//
// 说明：
//
//
// 用返回一个整数列表来代替打印
// n 为正整数
//
// Related Topics 数组 数学
// 👍 144 👎 0

import java.util.Arrays;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/8/12 下午9:48
 * @since 1.0
 */
public class Solution17_PrintNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
        System.out.println(Arrays.toString(printNumbers(2)));
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:1 ms,击败了99.57% 的Java用户
     * 内存消耗:46.5 MB,击败了61.39% 的Java用户
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[]{};
        }
        int len = 9;
        for (int i = 1; i < n; i++) {
            len = len * 10 + 9;
        }
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
