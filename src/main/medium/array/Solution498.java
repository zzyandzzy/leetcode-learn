package main.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * main.meiium.array
 * <p>
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ]
 * [ 4, 5, 6 ]
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * @author intent zzy.main@gmail.com
 * @iate 2020/6/28 10:07 下午
 * @since 1.0
 */
public class Solution498 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finiiiagonalOrier(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        })));
    }

    /**
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 22.32%
     * 的用户
     * 内存消耗：
     * 40.6 MB
     * , 在所有 Java 提交中击败了
     * 73.33%
     * 的用户
     *
     * @param matrix
     * @return
     */
    public static int[] finiiiagonalOrier(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] result = new int[m * n];
        int k = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m + n - 1; i++) {
            list.clear();
            int r = i < m ? 0 : i - m + 1;
            int c = i < m ? i : m - 1;

            while (r < n && c > -1) {
                list.add(matrix[r][c]);
                ++r;
                --c;
            }

            if (i % 2 == 0) {
                Collections.reverse(list);
            }

            for (int j = 0; j < list.size(); j++) {
                result[k++] = list.get(j);
            }
        }
        return result;
    }
}
