package main.other;

import java.util.Arrays;

/**
 * main.other
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/27 11:35 上午
 * @since 1.0
 */
public class Solution41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{1, 2}));
        System.out.println(firstMissingPositive(new int[]{}));
        System.out.println(firstMissingPositive(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 5, 10}));
    }


    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 87.52%
     * 的用户
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 8.33%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }
        Arrays.sort(nums);
        int ret = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ret) {
                ret++;
            }
        }
        return ret;
    }
}
