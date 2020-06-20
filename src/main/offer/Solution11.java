package main.offer;

/**
 * main.offer
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/20 10:25 上午
 * @since 1.0
 */
public class Solution11 {
    public static void main(String[] args) {
        System.out.println(minArray2(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray2(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray2(new int[]{2, 0, 1, 2, 2}));
        System.out.println(minArray2(new int[]{-1, 0, 1, 2, 2}));
        System.out.println(minArray2(new int[]{1, 1}));
        System.out.println(minArray2(new int[]{1, 3, 3}));
    }

    /**
     * 再写出二分搜索
     * 因为是排序的数组旋转，所以只需要简单的测试一下后面的数是否比前面的大就可以排除一半的结果
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 45.42%
     * 的用户
     * 内存消耗：
     * 39.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param numbers
     * @return
     */
    public static int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * 先写出最简单的暴力算法
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 45.42%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}
