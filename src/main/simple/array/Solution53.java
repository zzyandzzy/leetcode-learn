package main.simple.array;

/**
 * main
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/5/16 7:39 下午
 * @since 1.0
 */
public class Solution53 {
    public static void main(String[] args) {
        // 首先想到暴力法和滑动窗口
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
//        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 暴力法，循环数组，从1开始到数组大小计算每个的和是多少，取最大值,时间复杂度O(n^2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


    /**
     * 贪心算法
     * 若之前的和大于零，就和当前的值相加，小于零就舍弃
     *
     * @param nums 数组
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 之前的和
        int pre = nums[0];
        // 最大值
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0) {
                pre = pre + nums[i];
            } else {
                pre = nums[i];
            }
            if (pre > max) {
                max = pre;
            }
        }
        return max;
    }
}
