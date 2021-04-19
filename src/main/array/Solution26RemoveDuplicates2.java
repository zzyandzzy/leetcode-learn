package main.array;

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
// 说明：
//
// 为什么返回数值是整数，但输出的答案是数组呢？
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
//
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的
//元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// nums 已按升序排列
//
// Related Topics 数组 双指针
// 👍 507 👎 0

import java.util.Arrays;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/3/23 22:27
 * @since 1.0
 */
public class Solution26RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] num = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(num));
        System.out.println(Arrays.toString(num));
        int[] num2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(num2));
        System.out.println(Arrays.toString(num2));
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了74.64% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len < 2 || nums[i] != nums[len - 2]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
