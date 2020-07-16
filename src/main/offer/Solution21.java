package main.offer;

import java.util.*;

/**
 * main.offer
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/16 8:43 下午
 * @since 1.0
 */
public class Solution21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange2(new int[]{
                1, 2, 3, 4
        })));
    }

    /**
     * 首尾指针法
     * <p>
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 99.79%
     * 的用户
     * 内存消耗：
     * 49.8 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int[] exchange2(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int[] ret = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ret[right--] = num;
            } else {
                ret[left++] = num;
            }
        }
        return ret;
    }

    /**
     * 先用最笨的方法
     * 两个栈
     * <p>
     * 执行用时：
     * 9 ms
     * , 在所有 Java 提交中击败了
     * 5.62%
     * 的用户
     * 内存消耗：
     * 48.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * <p>
     * 果然是最耗时的。。。
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                s2.offer(num);
            } else {
                s1.offer(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (s1.size() > 0) {
                nums[i] = s1.poll();
            } else if (s2.size() > 0) {
                nums[i] = s2.poll();
            }
        }
        return nums;
    }
}
