package main.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * main.util
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/6 9:41 上午
 * @since 1.0
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    // [5,4,8,11,null,13,4,7,2,null,null,5,1]
    //
    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \    / \
    //        7    2  5   1
    public static Node createTree(Integer[] v) {
        if (v.length == 0) {
            return null;
        }
        //使用逐层遍历的方式，生成树
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(v[0]);
        q.add(root);
        //用以表示当前数组可用的元素下标
        int idx = 1;
        while (!q.isEmpty() && idx < v.length) {
            int cnt = q.size();
            for (int i = 1; i <= cnt; i++) {
                Node cur = q.poll();
                //判断左子树是否为空
                if (v[idx] != null) {
                    cur.left = new Node(v[idx]);
                    q.add(cur.left);
                }
                idx++;
                if (idx >= v.length) {
                    break;
                }
                //判断右子树是否为空
                if (v[idx] != null) {
                    cur.right = new Node(v[idx]);
                    q.add(cur.right);
                }
                idx++;
            }
        }
        return root;
    }
}
