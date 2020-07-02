package main.simple.string;

/**
 * main.simple.string
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/2 9:06 上午
 * @since 1.0
 */
public class Solution485 {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 0}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    /**
     * 直接双指针带走
     * <p>
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 39.01%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 5.26%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                left = 0;
                right++;
            } else {
                left++;
                right++;
            }
            sum = Math.max(sum, left);
        }
        return sum;
    }
}
