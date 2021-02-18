package main.offer;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。
//
//
//
// 示例1:
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100
//
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
//
//
// Related Topics 分治算法 动态规划
// 👍 202 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/2/18 17:10
 * @since 1.0
 */
public class Solution42 {
    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray2(new int[]{1}));
        System.out.println(maxSubArray2(new int[]{1, 2, 3}));
    }

    /**
     * 求最值问题，一般dp都可以解决
     * 分析：
     * ---[-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * dp=[-2, 1, -2, 4,  3, 5, 6,  1, 5]
     *
     * <p>
     * 解答成功:
     * 执行耗时:1 ms,击败了98.05% 的Java用户
     * 内存消耗:44.8 MB,击败了80.03% 的Java用户
     *
     * @param nums 数组
     * @return 最大和
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(nums[i], max);
        }
        return max;
    }

    /**
     * 先用最笨的方法通过吧。。。
     * 时间复杂度：O(n^2)
     * <p>
     * Time Limit Exceeded超时！！！
     *
     * @param nums 数组
     * @return 最大和
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}
