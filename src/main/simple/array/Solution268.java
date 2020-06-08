package main.simple.array;

/**
 * main
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/5 10:06 下午
 * @since 1.0
 */
public class Solution268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    /**
     * 等差数列前n项和
     * a1=0
     * 公差d = 1
     * 项数n
     * <p>
     * sn = n * (n-1)/2 * d
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int sn = ((nums.length + 1) * nums.length) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sn - sum;
    }
}
