package main.contest.weekly.n196;

import java.util.Arrays;

/**
 * main.contest.weekly.n196
 * 给你一个数字数组 arr 。
 * <p>
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * <p>
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 1000
 * -10^6 <= arr[i] <= 10^6
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/5 11:18 上午
 * @since 1.0
 */
public class Solution5452 {
    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length < 2){
            return false;
        }
        Arrays.sort(arr);
        int c = arr[1] - arr[0];
        for(int i = 0; i < arr.length; i++){
            if(i != arr.length - 1){
                if(arr[i + 1] - arr[i] != c){
                    return false;
                }
            }
        }
        return true;
    }
}
