package main.offer;

import main.util.TreeNode;
import main.util.TreeOperation;

import java.util.*;

// id: 剑指 Offer 32 - III
// title: 从上到下打印二叉树 III
// slug: cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索
// 👍 53 👎 0
public class Solution32_3 {
    private static final List<List<Integer>> node = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        TreeOperation.show(root);
        System.out.println(levelOrder(root));
    }

    /**
     * 两个栈
     * 双端栈
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(tmp);
            if (deque.isEmpty()) {
                break; // 若为空则提前跳出
            }
            // 打印偶数层
            tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            res.add(tmp);
        }
        return res;
    }

}
