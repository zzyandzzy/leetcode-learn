package main.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// id: 剑指 Offer 39
// title: 数组中出现次数超过一半的数字
// slug: shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
//
// Related Topics 位运算 分治算法
// 👍 106 👎 0

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/1/26 20:28
 * @since 1.0
 */
public class Solution39 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }

    /**
     * 投票法
     * 题目要求求出众数，两两一样的数相加或不一样的数相减，则最后的数一定是众数。
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了69.58% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int votes = 0;
        int ret = 0;
        for (int num : nums) {
            if (votes == 0) {
                ret = num;
            }
            votes += num == ret ? 1 : -1;
        }
        return ret;
    }

    /**
     * 排序法
     * 因为题目已经说了一定存在数组中出现次数超过一半的数字，所以排序后中间的数一定是那个数
     * 解答成功:
     * 执行耗时:2 ms,击败了59.60% 的Java用户
     * 内存消耗:41.9 MB,击败了36.83% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * HashMap法
     * 解答成功:
     * 执行耗时:15 ms,击败了24.65% 的Java用户
     * 内存消耗:43.2 MB,击败了27.47% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = nums[0];
        int count = 0;
        for (int num : nums) {
            Integer temp = map.get(num);
            if (temp == null) {
                map.put(num, 1);
            } else {
                map.put(num, temp + 1);
                if (temp + 1 > count) {
                    count = temp + 1;
                    ret = num;
                }
            }
        }
        return ret;
    }
}
