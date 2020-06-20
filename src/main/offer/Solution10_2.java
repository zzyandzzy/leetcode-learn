package main.offer;

/**
 * main.offer
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/20 10:19 上午
 * @since 1.0
 */
public class Solution10_2 {
    public static void main(String[] args) {
        System.out.println(numWays(2));
        System.out.println(numWays(3));
        System.out.println(numWays(4));
        System.out.println(numWays(5));
        System.out.println(numWays(6));
        System.out.println(numWays(7));
        System.out.println(numWays(8));
        System.out.println(numWays(45));
        System.out.println(numWays(46));
    }

    /**
     * 斐波那契数列
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.2 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < n + 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
