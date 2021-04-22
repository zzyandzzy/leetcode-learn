package cool.zzy.expore.array;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2393 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/4/21 22:44
 * @since 1.0
 */
public class Solution11MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
        System.out.println(maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));// 17
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:5 ms,击败了46.68% 的Java用户
     * 内存消耗:52 MB,击败了24.70% 的Java用户
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int step = right - left;
            max = Math.max(max, Math.min(height[left], height[right]) * step);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
