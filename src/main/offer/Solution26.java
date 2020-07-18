package main.offer;

import main.util.TreeNode;

/**
 * main.offer
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/17 22:32
 * @since 1.0
 */
public class Solution26 {
    public static void main(String[] args) {
        TreeNode aRoot = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        left.left = new TreeNode(1);
        left.right = new TreeNode(4);
        aRoot.left = left;
        aRoot.right = new TreeNode(5);
        TreeNode bRoot = new TreeNode(4);
        bRoot.left = new TreeNode(1);
        System.out.println(isSubStructure(aRoot, bRoot));
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (equalTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public static boolean equalTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return equalTree(a.left, b.left) && equalTree(a.right, b.right);
    }
}
