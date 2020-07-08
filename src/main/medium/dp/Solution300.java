package main.medium.dp;

/**
 * main.medium.dp
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/8 9:26 下午
 * @since 1.0
 */
public class Solution300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * 执行用时：
     * 15 ms
     * , 在所有 Java 提交中击败了
     * 42.52%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 7.14%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * 先用快慢指针试试
     * [10,9,2,5,3,7,101,18]
     * 不行！！！因为数据可以不是连续的
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int len = 0;
        int slow = -1;
        int fast = 0;
        while (fast < nums.length - 1) {
            slow++;
            fast++;
            if (nums[fast] > nums[slow]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 0;
            }
        }
        max = Math.max(max, len);
        return max;
    }
}
