package main.offer;

import main.util.TreeNode;
import main.util.TreeOperation;

/**
 * main.offer
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/18 20:21
 * @since 1.0
 */
public class Solution27 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        root.left = left;
        root.right = right;
        TreeOperation.show(root);
        TreeOperation.show(mirrorTree(root));
    }

    static TreeNode r;

    /**
     * 递归换子节点
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return r;
        }
        if (r == null) {
            r = root;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return r;
    }


}
