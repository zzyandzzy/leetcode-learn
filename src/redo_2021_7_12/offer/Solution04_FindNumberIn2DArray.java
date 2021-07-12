package redo_2021_7_12.offer;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// Related Topics 数组 二分查找 分治 矩阵
// 👍 385 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/12 8:28 下午
 * @since 1.0
 */
public class Solution04_FindNumberIn2DArray {
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
        System.out.println(findNumberIn2DArray2(new int[][]{}, 6));
        System.out.println(findNumberIn2DArray2(new int[][]{{}}, 6));
        System.out.println(findNumberIn2DArray2(new int[][]{{1, 1}}, 1));
    }

    /**
     * findNumberIn2DArray999方法失败了，但是思想还是可以借用的！
     * 题目说了每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * //  [1,   4,  7, 11, 15],
     * //  [2,   5,  8, 12, 19],
     * //  [3,   6,  9, 16, 22],
     * //  [10, 13, 14, 17, 24],
     * //  [18, 21, 23, 26, 30]
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44 MB,击败了70.54% 的Java用户
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    /**
     * 双重禁忌太暴力了，来点温和的☺️☺️☺️
     * 二分查找法，题目说了每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 有如下二维数组：
     * int[][] matrix = new int[][]{
     * {1, 4, 7, 11, 15},
     * {2, 5, 8, 12, 19},
     * {3, 6, 9, 16, 22},
     * {10, 13, 14, 17, 24},
     * {18, 21, 23, 26, 30}
     * };
     * 则如果查找的是5，先从上到下查找，遇到比5大的直接停止。此时有效数组为：
     * int[][] matrix = new int[][]{
     * {1, 4, 7, 11, 15},
     * {2, 5, 8, 12, 19},
     * {3, 6, 9, 16, 22}
     * };
     * 则再从左到右查找，遇到比5大的也停止。此时有效数组为：
     * int[][] matrix = new int[][]{
     * {1, 4},
     * {2, 5},
     * {3, 6}
     * };
     * 再执行第二列从上到下的查找即可。
     * 可以个毛线！！！遇到[[1,1]]的情况就出错了！！！
     *
     * @param matrix
     * @param target
     * @return
     */
    @Deprecated
    public static boolean findNumberIn2DArray999(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowLimit = matrix[0].length;
        int colLimit = matrix.length;
        // 先从上到下查找，遇到比target大的直接停止
        for (int i = 0; i < colLimit; i++) {
            if (matrix[i][0] == target) {
                return true;
            } else if (matrix[i][0] > target) {
                colLimit = i;
                break;
            }
        }
        // 再从左到右查找，遇到比target大的也停止。
        for (int i = 0; i < rowLimit; i++) {
            if (matrix[i][0] == target) {
                return true;
            } else if (matrix[i][0] > target) {
                rowLimit = i;
                break;
            }
        }
        // 再执行第二列从上到下的查找即可
        for (int i = 1; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    rowLimit = i;
                    colLimit = j;
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 双重for循环直接找🐴
     * 小丑竟是我自己？？？🤡🤡🤡
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.2 MB,击败了48.59% 的Java用户
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
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
