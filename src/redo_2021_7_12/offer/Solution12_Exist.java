package redo_2021_7_12.offer;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
// 同一个单元格内的字母不允许被重复使用。
//
//
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],
//              ["S","F","C","S"],
//              ["A","D","E","E"]], word = "ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],
//              ["c","d"]], word = "abcd"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 数组 回溯 矩阵
// 👍 362 👎 0


/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/16 10:17 下午
 * @since 1.0
 */
public class Solution12_Exist {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'c', 'b', 'c', 'e'},
                {'b', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'},
        }, "fdec"));
    }

    /**
     * 解答成功:
     * 执行耗时:4 ms,击败了99.75% 的Java用户
     * 内存消耗:40.5 MB,击败了12.40% 的Java用户
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 上下左右搜索
     *
     * @param board
     * @param words
     * @param i
     * @param j
     * @param k
     * @return
     */
    private static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != words[k]) {
            return false;
        }
        if (words.length - 1 == k) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean ret = dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);
        board[i][j] = temp;
        return ret;
    }
}
