package cool.zzy.expore.array;
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 双指针 二分查找
// 👍 621 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/4/23 10:54
 * @since 1.0
 */
public class Solution209MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:270 ms,击败了5.00% 的Java用户
     * 内存消耗:38.5 MB,击败了46.04% 的Java用户
     * <p>
     * 滑动窗口解决
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        while (start < nums.length) {
            int sum = 0;
            // 计算start - end的和
            for (int j = start; j <= end; j++) {
                sum += nums[j];
            }
            if (sum >= target) {
                if (minEnd - minStart > end - start) {
                    minStart = start;
                    minEnd = end;
                } else {
                    start++;
                }
            } else {
                if (end != nums.length - 1) {
                    end++;
                } else {
                    start++;
                }
            }
        }
        return (minEnd - minStart) == Integer.MAX_VALUE ? 0 : (minEnd - minStart) + 1;
    }


    /**
     * 看错题了！！！
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
     * <p>
     * 解成等于target的最小连续子数组了
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        while (start < nums.length) {
            int sum = 0;
            // 计算start - end的和
            for (int j = start; j <= end; j++) {
                sum += nums[j];
            }
            if (sum == target && minEnd - minStart > end - start) {
                minStart = start;
                minEnd = end;
                if (end != nums.length - 1) {
                    end++;
                } else {
                    start++;
                }
            } else if (sum < target) {
                if (end != nums.length - 1) {
                    end++;
                } else {
                    start++;
                }
            } else if (sum > target) {
                start++;
                if (end != nums.length - 1) {
                    end++;
                }
            }
        }
        return (minEnd - minStart) == Integer.MAX_VALUE ? 0 : (minEnd - minStart) + 1;
    }
}
