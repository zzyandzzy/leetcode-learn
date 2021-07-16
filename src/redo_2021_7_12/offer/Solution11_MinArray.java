package redo_2021_7_12.offer;


//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如，数组 [3,4,5,1,2]
//        为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 数组 二分查找
// 👍 357 👎 0

import java.util.Arrays;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/16 9:48 下午
 * @since 1.0
 */
public class Solution11_MinArray {
    public static void main(String[] args) {
        System.out.println(minArray3(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray3(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray3(new int[]{2, 0, 1, 2, 2}));
        System.out.println(minArray3(new int[]{-1, 0, 1, 2, 2}));
        System.out.println(minArray3(new int[]{1, 1}));
        System.out.println(minArray3(new int[]{1, 3, 3}));
    }

    /**
     * 这好像可以二分
     * 首先，取中间
     * 如果中间的数比最右边的数大，说明最小值在右边，[3, 4, 5, 1, 2]，因为是旋转的数组嘛
     * 如果中间的数比最右边的数小，说明最小值在左边，[2, 0, 1, 2, 2]
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了63.73% 的Java用户
     *
     * @param numbers
     * @return
     */
    public static int minArray3(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // 对应[1, 3, 3]这种情况
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * 直接排序取第一个！
     * 执行耗时:1 ms,击败了26.65% 的Java用户
     * 内存消耗:38.3 MB,击败了29.64% 的Java用户
     * 这性能差距，连暴力都不如！！！
     * 🙄
     *
     * @param numbers
     * @return
     */
    public static int minArray2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        Arrays.sort(numbers);
        return numbers[0];
    }

    /**
     * 题目读完，找最小？？？这个我可就不困了
     * 直接暴力、直接排序。。。😏🤔😯🤤😶
     *
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了33.20% 的Java用户
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        // 暴力
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}
