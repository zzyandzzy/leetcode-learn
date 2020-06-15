package main.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * main.interview
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/15 5:55 下午
 * @since 1.0
 */
public class Solution0108 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
        System.out.println(Arrays.deepToString(setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}})));
        System.out.println(Arrays.deepToString(setZeroes(new int[][]{{0, 1,}})));
    }

    /**
     * 记录0出现的位置，再进行清空
     * info
     * 解答成功:
     * 执行耗时:3 ms,击败了19.46% 的Java用户
     * 内存消耗:41.5 MB,击败了100.00% 的Java用户
     *
     * @param matrix
     * @return
     */
    public static int[][] setZeroes(int[][] matrix) {
        int m = matrix.length;
        // 记录0出现时的行和列
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int n = matrix[i].length;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        // 清空行
        row.forEach(r -> {
            int columnLength = matrix[r].length;
            for (int i = 0; i < columnLength; i++) {
                matrix[r][i] = 0;
            }
        });
        // 清空列
        column.forEach(c -> {
            for (int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        });
        return matrix;
    }
}
