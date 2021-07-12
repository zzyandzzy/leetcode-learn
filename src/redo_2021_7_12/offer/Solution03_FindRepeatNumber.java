package redo_2021_7_12.offer;


//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表 排序
// 👍 476 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/12 4:43 下午
 * @since 1.0
 */
public class Solution03_FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber3(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber3(new int[]{1, 3, 5, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber3(new int[]{1, 0, 1}));
    }

    /**
     * 最后想到交换法，仔细看题目有个条件，nums 里的所有数字都在 0～n-1 的范围内。可以利用这个条件把元素的值作为下标交换。
     * nums = [1, 3, 5, 0, 2, 5, 3]
     * 第1步：     i = 0,交换num[0]，[3, 1, 5, 0, 2, 5, 3]
     * 第1.1步：   i = 0,交换num[0]，[0, 1, 5, 3, 2, 5, 3]，因为num[0] = 0，跳出
     * 第2步：     i = 1,交换num[1]，[0, 1, 5, 3, 2, 5, 3]，因为num[1] = 1，跳出
     * 第3步：     i = 2,交换num[2]，[0, 1, 2, 3, 2, 5, 3]，因为num[5] = 5，直接返回
     * 执行用时: 0 ms，击败了100% 的Java用户
     * 内存消耗: 46 MB
     * 提交时间：2 分钟前
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     * @since 1.1
     * @deprecated 有bug！！！
     * num = [2,3,1,0,2,5,3]
     * 第零步：初始化：tmp = num[0] = 2
     * 第一步：tmp为2，则换到下标为2的1处，此时：[2,1,2,0,2,5,3] tmp: 1
     * 第二步：tmp为1，则换到下标为1的3处，此时：[2,1,2,0,2,5,3] tmp: 3
     * 第三步：tmp为3，则换到下标为3的0处，此时：[2,1,2,0,2,5,3] tmp: 0
     * 第四步：tmp为0，则换到下标为0的2处，此时：[0,1,2,0,2,5,3] tmp: 2
     * 第五步：tmp为2，则换到下标为2的2处，此时因为下标为2处已经是2了，所以返回2
     * 上面的方法对于这种情况就会出现错误！！！
     * nums = [1, 3, 5, 0, 2, 5, 3]
     * 第零步：初始化：tmp = num[0] = 1
     * 第一步：tmp为1，则换到下标为1的3处，此时：[1, 1, 5, 0, 2, 5, 3] tmp: 3
     * 第二步：tmp为3，则换到下标为3的0处，此时：[1, 1, 5, 3, 2, 5, 3] tmp: 0
     * 第三步：tmp为0，则换到下标为0的1处，此时：[0, 1, 5, 3, 2, 5, 3] tmp: 1
     * 第四步：tmp为1，则换到下标为1的1处，此时出现错误！！！
     * 所以这种交换法是有bug的
     */
    public static int findRepeatNumber3(int[] nums) {
//        // 当前的指针
//        int current = 0;
//        // 要交换的位置
//        int tmp = nums[current];
//        while (nums[current] != nums[tmp]) {
//            // 要交换位置的值
//            int val = nums[tmp];
//            nums[tmp] = tmp;
//            current = tmp;
//            tmp = val;
//        }
//        return nums[current];
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 然后想到排序法，既然有重复的，排下序就知道了！
     * 时间复杂度：Arrays.sort这个排序是根据数组里面的元素来选择排序算法的，所以元素不同时间复杂度也不同：
     * 1. 当nums数组元素小于等于{@linkplain java.util.DualPivotQuicksort#QUICKSORT_THRESHOLD 即286个}时，用到的是快速排序
     * 2. 其他情况使用归并排序，时间复杂度：O(nlogn)
     * 快速排序的时间复杂度为：O(nlogn)，
     * 空间复杂度：得看排序的消耗，如果是快速排序：O(logn)，如果是归并排序：O(n)
     * <p>
     * info
     * 解答成功:
     * 执行耗时:2 ms,击败了67.79% 的Java用户
     * 内存消耗:46 MB,击败了77.14% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 再循环找
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 首先肯定想到了Set啦。
     * 时间复杂度：因为HashSet是用HashMap首先的，而contains方法最终首先为：{@link java.util.HashMap#getNode(int, Object)}
     * 可以在这个方法看到，对于链表，最坏情况下时间复杂度为O(n)，对于二叉树（HashMap为红黑二叉树），时间复杂度为O(logn)
     * 空间复杂度：因为需要额外的空间存储所有元素，所以为O(n)
     * info
     * 解答成功:
     * 执行耗时:7 ms,击败了35.98% 的Java用户
     * 内存消耗:47.1 MB,击败了43.28% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
