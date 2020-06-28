package main.contest.weekly.n195;

import java.util.ArrayList;
import java.util.List;

/**
 * main.contest.weekly.n195
 * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 * <p>
 * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
 * <p>
 * 如果存在这样的分法，请返回 True ；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * 输出：true
 * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5,6], k = 7
 * 输出：true
 * 解释：划分后的数字对为 (1,6),(2,5) 以及 (3,4) 。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5,6], k = 10
 * 输出：false
 * 解释：无法在将数组中的数字分为三对的同时满足每对数字和能够被 10 整除的条件。
 * 示例 4：
 * <p>
 * 输入：arr = [-10,10], k = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：arr = [-1,1,-2,2,-3,3,-4,4], k = 3
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr.length == n
 * 1 <= n <= 10^5
 * n 为偶数
 * -10^9 <= arr[i] <= 10^9
 * 1 <= k <= 10^5
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/28 10:40 上午
 * @since 1.0
 */
public class Solution5449 {
    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        System.out.println(canArrange(new int[]{-10, 10}, 2));
        System.out.println(canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));
    }

    public static boolean canArrange(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] != Integer.MAX_VALUE && arr[j] != Integer.MAX_VALUE &&
                        (arr[i] + arr[j]) % k == 0) {
                    arr[i] = Integer.MAX_VALUE;
                    arr[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        for (int i : arr) {
            if (i != Integer.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }
}
