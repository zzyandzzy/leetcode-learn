package main.offer;

// id: 剑指 Offer 40
// title: 最小的k个数
// slug: zui-xiao-de-kge-shu-lcof
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 183 👎 0

import java.util.Arrays;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/1/27 12:42
 * @since 1.0
 */
public class Solution40 {
    public static void main(String[] args) {
//        arr = [3,2,1], k = 2
//        arr = [0,1,2,1], k = 1
        int arr[] = {3, 2, 1};
        int arr2[] = {0, 1, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 2)));
        System.out.println(Arrays.toString(getLeastNumbers(arr2, 1)));
    }

    /**
     * 排序法
     * 执行耗时:7 ms,击败了71.60% 的Java用户
     * 内存消耗:39.7 MB,击败了64.45% 的Java用户
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
