package main.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * main.offer
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/10 9:39 下午
 * @since 1.0
 */
public class Solution13 {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }

    /**
     * BFS 广度优先搜索
     * <p>
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 20.20%
     * 的用户
     * 内存消耗：
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 存放数组，第一位是i，第两位是j
        queue.offer(new int[]{0, 0});
        int ans = 0;
        while (queue.size() > 0) {
            int[] temp = queue.poll();
            int i = temp[0], j = temp[1];
            if (i >= m || j >= n || visited[i][j] || count(i, j) > k) {
                continue;
            }
            visited[i][j] = true;
            ans++;
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i, j + 1});
        }
        return ans;
    }

    /**
     * 返回数位和
     *
     * @param i
     * @param j
     * @return
     */
    public static int count(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum;
    }
}
