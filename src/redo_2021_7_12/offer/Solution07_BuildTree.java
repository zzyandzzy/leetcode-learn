package redo_2021_7_12.offer;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 示例 1:
//
//
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
//
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
// Related Topics 树 数组 哈希表 分治 二叉树
// 👍 500 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import main.util.TreeNode;
import main.util.TreeOperation;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/14 11:05 上午
 * @since 1.0
 */
public class Solution07_BuildTree {
    public static void main(String[] args) {
//        TreeOperation.show(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
//        TreeOperation.show(buildTree(new int[]{1, 2}, new int[]{2, 1}));
        TreeOperation.show(buildTree(
                new int[]{3, 9, 8, 5, 4, 10, 20, 15, 7},
                new int[]{4, 5, 8, 10, 9, 3, 15, 20, 7}));
    }

    /**
     * 知道原理，但写不出来代码！！！
     * 递归调用
     * 解答成功:
     * 执行耗时:5 ms,击败了29.74% 的Java用户
     * 内存消耗:38.1 MB,击败了95.04% 的Java用户
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1);
    }

    /**
     * @param preorder
     * @param inorder
     * @param preLeft  前序数组左边
     * @param preRight 前序数组右边
     * @param inLeft   中序数组左边
     * @param inRight  中序数组右边
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder,
                                      int preLeft, int preRight,
                                      int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 先取得pre的值
        int preVal = preorder[preLeft];
        TreeNode root = new TreeNode(preVal);
        // 说明没有可以遍历的了
        if (preLeft == preRight) {
            return root;
        }
        int rootIndex = preLeft;
        // 在inorder中查找preVal
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preVal) {
                rootIndex = i;
            }
        }
        // 左子树的长度
        int leftLen = rootIndex - inLeft;
        // 右子树的长度
        int rightLen = inRight - rootIndex;
        root.left = buildTree(preorder, inorder,
                preLeft + 1, preLeft + leftLen,
                inLeft, rootIndex - 1);
        root.right = buildTree(preorder, inorder,
                preRight - rightLen + 1, preRight,
                rootIndex + 1, inRight);
        return root;
    }
}
