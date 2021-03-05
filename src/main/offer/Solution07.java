package main.offer;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 339 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import main.util.TreeNode;
import main.util.TreeOperation;

import java.util.Arrays;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/3/5 22:11
 * @since 1.0
 */
public class Solution07 {
    public static void main(String[] args) {
        TreeOperation.show(buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}));
//        TreeOperation.show(buildTree(
//                new int[]{1, 2, 4, 7, 3, 5, 6},
//                new int[]{4, 7, 2, 1, 5, 3, 6}));
    }

    /**
     * 前序遍历数组中第一个总是根节点，中序遍历数组中的根节点分开左节点和右节点，递归则可以创建树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 执行耗时:12 ms,击败了19.37% 的Java用户
     * 内存消耗:88.2 MB,击败了10.96% 的Java用户
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        int rootIndex = 0;
        // 找到分界点
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        // 构建树
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
                Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(
                Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length),
                Arrays.copyOfRange(inorder, 1 + rootIndex, inorder.length));
        return root;
    }
}
