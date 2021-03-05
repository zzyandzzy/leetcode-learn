//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
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
//leetcode submit region end(Prohibit modification and deletion)
