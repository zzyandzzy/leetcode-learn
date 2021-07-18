package redo_2021_7_12.offer;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
//
//
// 提示：
//
//
// 2 <= n <= 1000
//
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划
// 👍 125 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/17 2:49 下午
 * @since 1.0
 */
public class Solution14_2_CuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(3));
        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope(6));
        System.out.println(cuttingRope(8));
        System.out.println(cuttingRope(10));
    }

    /**
     * 动态规划
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.5 MB,击败了9.08% 的Java用户
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        long[] dp = new long[n + 7];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n <= 6) {
            return (int) dp[n];
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = (dp[i - 3] * 3) % 1000000007;
        }
        return (int) dp[n];
    }
}
