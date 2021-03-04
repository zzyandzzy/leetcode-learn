package main.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * main.offer
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 5:05 下午
 * @since 1.0
 */
public class Solution03 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber3(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber3(new int[]{1, 3, 5, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber3(new int[]{1, 0, 1}));
    }

    /**
     * 交换法，因为数字都在0~n-1之内
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 45.9 MB
     * , 在所有 Java 提交中击败了
     * 93.48%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 如果要交换的下标本来就是这个数，则说明重复了
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 交换下标
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 执行用时：
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 42.61%
     * 的用户
     * 内存消耗：
     * 49.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 执行用时：
     * 15 ms
     * , 在所有 Java 提交中击败了
     * 8.91%
     * 的用户
     * 内存消耗：
     * 50.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value >= 2) {
                return key;
            }
        }
        return -1;
    }
}
