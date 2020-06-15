package main.interview;

import java.util.Arrays;

/**
 * main.interview
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
 * 请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/15 4:24 下午
 * @since 1.0
 */
public class Solution0107 {
    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(rotate2(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}})));
    }

    /**
     * 看了答案后还知道了原地翻转（原地起跳？？？）的方法
     * 先水平翻转，再对角线翻转
     * 第一步：
     * 5  1  9 11                 15 14 12 16
     * 2  4  8 10                 13  3  6  7
     * ------------   =水平翻转=>   ------------
     * 13  3  6  7                  2  4  8 10
     * 15 14 12 16                  5  1  9 11
     * <p>
     * 第二步：
     * 15 14 12 16                   15 13  2  5
     * 13  3  6  7   =主对角线翻转=>   14  3  4  1
     * 2  4  8 10                   12  6  8  9
     * 5  1  9 11                   16  7 10 11
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public static int[][] rotate2(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return matrix;
        }
        // 先水平翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int posY = len - i - 1;
                // 交换数据
                int temp = matrix[posY][j];
                matrix[posY][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 再对角线交换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

    /**
     * 旋转90度
     * 其中每个数组的位置都确定：
     * 比如：
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * 1 向上转了0，再向右转了2，再向下转了0，再向左转了0
     * 2 向上转了0，再向右转了1，再向下转了1，再向左转了0
     * 3 向上转了0，再向右转了0，再向下转了2，再向左转了0
     * 4 向上转了1，再向右转了1，再向下转了0，再向左转了0
     * 5 向上转了0，再向右转了0，再向下转了0，再向左转了0
     * 6 向上转了0，再向右转了0，再向下转了1，再向左转了1
     * 7 向上转了2，再向右转了0，再向下转了0，再向左转了0
     * 8 向上转了1，再向右转了0，再向下转了0，再向左转了1
     * 9 向上转了0，再向右转了0，再向下转了0，再向左转了2
     * <p>
     * 这里其实不使用额外数组也行
     * info
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了100.00% 的Java用户
     *
     * @param matrix
     * @return
     */
    public static int[][] rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return matrix;
        }
        int ret[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // 要交换的位置
                int swapPosX = j;
                int swapPosY = len - i - 1;
                ret[swapPosX][swapPosY] = matrix[i][j];
            }
        }
        return ret;
    }
}
