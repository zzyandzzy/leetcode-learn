package main.offer;

/**
 * main.offer
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/11 7:42 下午
 * @since 1.0
 */
public class Solution14_1 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(3));
        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope2(6));
        System.out.println(cuttingRope2(8));
        System.out.println(cuttingRope2(10));
    }

    /**
     * dp
     * n=2:  1+1  -->1*1=1;   				dp[2]=1;
     * n=3:  2+1  -->2*1=2;   				dp[3]=2;
     * n=4:  2+2  -->2*2=4;   				dp[4]=4;
     * n=5:  3+2  -->3*2=6;   				dp[5]=6;
     * 貌似看不出规律，别急再多写几个
     * n=6:  3+3  -->3*3=4;                 dp[6]=9;
     * n=7:  4+3  -->4*3=12;-->dp[4]*3=12   dp[7]=12;
     * n=8:  5+3  -->6*3=12;-->dp[5]*3=18   dp[8]=18;
     * n=9:  6+3  -->9*3=12;-->dp[6]*3=27   dp[9]=27;
     * n=10: 7+3  -->12*3=36;-->dp[7]*3=12   dp[10]=36;
     * <p>
     * 作者：xiao-bai-323
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/kan-bu-dong-suan-wo-shu-de-ti-jie-dong-tai-gui-hua/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int cuttingRope2(int n) {
        int[] dp = new int[n + 7];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n <= 6) {
            return dp[n];
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }

    /**
     * 数学双O(1)！！！
     * tql
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    /**
     * 暴力法！！！
     * 不可取！！！
     *
     * @param n
     * @return
     */
//    public static int cuttingRope(int n) {
//        if (n == 3) {
//            return 2;
//        }
//        int maxAns = 1;
//        int index = 2;
//        while (index != n) {
//            int i = n / index;
//            int carry = n % index;
//            int sum = 1;
//            for (int j = 0; j < i; j++) {
//                if (j != i - 1) {
//                    sum *= index;
//                } else {
//                    sum *= (index + carry);
//                }
//            }
//            maxAns = Math.max(maxAns, sum);
//            index++;
//        }
//        return maxAns;
//    }
}
