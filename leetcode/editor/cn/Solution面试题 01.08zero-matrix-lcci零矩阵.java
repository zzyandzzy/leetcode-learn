// id: 面试题 01.08
// title: 零矩阵
// slug: zero-matrix-lcci
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
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
    }
}
//leetcode submit region end(Prohibit modification and deletion)
