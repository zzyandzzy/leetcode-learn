package main.biweekly.contest.n29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5434. 删掉一个元素以后全为 1 的最长子数组
 * <p>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/27 10:00 下午
 * @since 1.0
 */
public class Solution5434 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 0}));
        System.out.println(longestSubarray(new int[]{1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 0, 0}));
        System.out.println(longestSubarray(new int[]{1, 0, 0, 0, 0}));
        System.out.println(longestSubarray(new int[]{1, 0, 0, 1, 0}));
        System.out.println(longestSubarray(new int[]{0, 0, 1, 1}));
    }

    /**
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1) {
                count++;
                if (i < nums.length - 2 && nums[i + 1] == 0 && nums[i + 2] == 0) {
                    list.add(count);
                    count = 0;
                }
            } else if (nums[i] == 0 && nums[i + 1] == 1) {
                int j = i + 1;
                for (; j < nums.length; j++) {
                    if (nums[j] == 1) {
                        count++;
                    } else {
                        break;
                    }
                }
                list.add(count);
                count = 0;
            } else if (nums[i] == 0 && nums[i + 1] == 0) {
                count = 0;
            }
        }
        if (count != 0 && list.size() == 0) {
            return count;
        }
        int max = 0;
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }
}
