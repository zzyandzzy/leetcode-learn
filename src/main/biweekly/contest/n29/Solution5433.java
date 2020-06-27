package main.biweekly.contest.n29;

import java.util.ArrayList;
import java.util.List;

/**
 * main.biweekly.contest.n29
 * n 的第 k 个因子
 * <p>
 * 给你两个正整数 n 和 k 。
 * <p>
 * 如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。
 * <p>
 * 考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12, k = 3
 * 输出：3
 * 解释：因子列表包括 [1, 2, 3, 4, 6, 12]，第 3 个因子是 3 。
 * 示例 2：
 * <p>
 * 输入：n = 7, k = 2
 * 输出：7
 * 解释：因子列表包括 [1, 7] ，第 2 个因子是 7 。
 * 示例 3：
 * <p>
 * 输入：n = 4, k = 4
 * 输出：-1
 * 解释：因子列表包括 [1, 2, 4] ，只有 3 个因子，所以我们应该返回 -1 。
 * 示例 4：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：1
 * 解释：因子列表包括 [1] ，第 1 个因子为 1 。
 * 示例 5：
 * <p>
 * 输入：n = 1000, k = 3
 * 输出：4
 * 解释：因子列表包括 [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 1000
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/28 12:09 上午
 * @since 1.0
 */
public class Solution5433 {
    public static void main(String[] args) {

    }

    public static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        if (k > list.size()) {
            return -1;
        }
        Integer ret = list.get(k - 1);
        return ret == null ? -1 : ret;
    }
}
