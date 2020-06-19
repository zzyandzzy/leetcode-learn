package main.offer;

/**
 * main.offer
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 5:20 下午
 * @since 1.0
 */
public class Solution4 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray2(matrix, 5));
        System.out.println(findNumberIn2DArray2(matrix, 20));
        System.out.println(findNumberIn2DArray2(new int[][]{{5}, {6}}, 6));
    }

    /**
     * 我们根据题意分析可得，从左往右搜索，遇到比target大的就换下一行
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 23.60%
     * 的用户
     * 内存消耗：
     * 45.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int row = 0;
        int column = 0;
        while (column < matrix.length) {
            int len = matrix[column].length;
            while (row < len) {
                if (matrix[column][row] == target) {
                    return true;
                } else if (matrix[column][row] < target) {
                    row++;
                } else {
                    row = 0;
                    column++;
                    break;
                }
            }
            if (row == len) {
                column++;
                row = 0;
            }
        }
        return false;
    }

    /**
     * 先写一个最普通的版本，一个一个的查找。。。
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 45.6 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int len = matrix[i].length;
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
