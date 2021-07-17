package redo_2021_7_12.offer;

// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
// 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
// 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
//输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
//输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// Related Topics 深度优先搜索 广度优先搜索 动态规划
// 👍 321 👎 0

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/17 1:58 下午
 * @since 1.0
 */
public class Solution13_MovingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }

    /**
     * 深度优先😳
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了88.13% 的Java用户
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }

    private static int dfs(int m, int n, int k, boolean[][] visited, int i, int j) {
        if (i >= m || j >= n || k < sum(i) + sum(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(m, n, k, visited, i + 1, j) +
                dfs(m, n, k, visited, i, j + 1);
    }

    private static int sum(int n) {
        return n / 10 + n % 10;
    }
}
