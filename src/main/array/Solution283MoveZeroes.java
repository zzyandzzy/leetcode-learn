package main.array;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 993 👎 0

import java.util.Arrays;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/3/16 21:46
 * @since 1.0
 */
public class Solution283MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{1, 3, 12, 0, 0});
        moveZeroes(new int[]{1});
        moveZeroes(new int[]{0});
        moveZeroes(new int[]{0, 1});
        moveZeroes(new int[]{});
        moveZeroes(null);
    }

    public static void moveZeroes(int[] nums) {
        if (null == nums) {
            return;
        }
        int p1 = 0, p2 = 0;
        for (p1 = 0; p1 < nums.length; p1++) {
            if (nums[p1] != 0) {
                nums[p2++] = nums[p1];
            }
        }
        while (p2 < nums.length) {
            nums[p2++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
