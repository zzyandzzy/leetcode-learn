package main.contest.weekly.n196;

/**
 * main.contest.weekly.n196
 * 给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
 * <p>
 * 你可以交换这个整数相邻数位的数字 最多 k 次。
 * <p>
 * 请你返回你能得到的最小整数，并以字符串形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：num = "4321", k = 4
 * 输出："1342"
 * 解释：4321 通过 4 次交换相邻数位得到最小整数的步骤如上图所示。
 * 示例 2：
 * <p>
 * 输入：num = "100", k = 1
 * 输出："010"
 * 解释：输出可以包含前导 0 ，但输入保证不会有前导 0 。
 * 示例 3：
 * <p>
 * 输入：num = "36789", k = 1000
 * 输出："36789"
 * 解释：不需要做任何交换。
 * 示例 4：
 * <p>
 * 输入：num = "22", k = 22
 * 输出："22"
 * 示例 5：
 * <p>
 * 输入：num = "9438957234785635408", k = 23
 * 输出："0345989723478563548"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 30000
 * num 只包含 数字 且不含有 前导 0 。
 * 1 <= k <= 10^9
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/5 11:22 上午
 * @since 1.0
 */
public class Solution5455 {
    public static void main(String[] args) {
        System.out.println(minInteger("4321", 4));
        System.out.println(minInteger("100", 1));
        System.out.println(minInteger("36789", 1000));
        System.out.println(minInteger("22", 22));
        System.out.println(minInteger("9438957234785635408", 23));
    }

    public static String minInteger(String num, int k) {
        int len = Math.min(num.length(), k);
        char[] arr = num.toCharArray();
        int w = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[0] - '0';

        }
        return new String(arr);
    }
}
