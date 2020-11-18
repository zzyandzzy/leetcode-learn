package main.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * main.util
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 5:58 下午
 * @since 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // [5,4,8,11,null,13,4,7,2,null,null,5,1]
    //
    //               5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \    / \
    //        7    2  5   1
    public static TreeNode createTree(Integer[] v) {
        if (v.length == 0) {
            return null;
        }
        //使用逐层遍历的方式，生成树
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(v[0]);
        q.add(root);
        //用以表示当前数组可用的元素下标
        int idx = 1;
        while (!q.isEmpty() && idx < v.length) {
            int cnt = q.size();
            for (int i = 1; i <= cnt; i++) {
                TreeNode cur = q.poll();
                //判断左子树是否为空
                if (v[idx] != null) {
                    cur.left = new TreeNode(v[idx]);
                    q.add(cur.left);
                }
                idx++;
                if (idx >= v.length) {
                    break;
                }
                //判断右子树是否为空
                if (v[idx] != null) {
                    cur.right = new TreeNode(v[idx]);
                    q.add(cur.right);
                }
                idx++;
            }
        }
        return root;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
