package main.offer;

// id: 剑指 Offer 34
// title: 二叉树中和为某一值的路径
// slug: er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 10000
//


//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
// Related Topics 树 深度优先搜索
// 👍 106 👎 0

import main.util.TreeNode;
import main.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author intent zzy.main@gmail.com
 * @date 2020/11/18 19:08
 * @since 1.0
 */
public class Solution34 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        TreeOperation.show(root);
        List<List<Integer>> ret = pathSum(root, 22);
        System.out.println(ret);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 27.94%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 54.45%
     * 的用户
     *
     * @param root
     * @param sum
     */
    private static void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, sum);
        recur(root.right, sum);
        path.removeLast();
    }
}
