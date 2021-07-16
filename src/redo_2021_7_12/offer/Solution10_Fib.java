package redo_2021_7_12.offer;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//
//
// 示例 2：
//
//
//输入：n = 5
//输出：5
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
// Related Topics 记忆化搜索 数学 动态规划
// 👍 168 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/14 5:18 下午
 * @since 1.0
 */
public class Solution10_Fib {
    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(45));
        System.out.println(fib(100));
    }

    /**
     * 一个数记录之前的值
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:34.8 MB,击败了97.84% 的Java用户
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        int sum;
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
