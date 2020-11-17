package main.offer;
// id: 剑指 Offer 33
// title: 二叉搜索树的后序遍历序列
// slug: er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// 👍 143 👎 0

import java.util.Arrays;

/**
 * @author intent zzy.main@gmail.com
 * @date 2020/11/17 21:38
 * @since 1.0
 */
public class Solution33 {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{}));
        System.out.println(verifyPostorder(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(verifyPostorder(new int[]{7, 4, 6, 5}));
        System.out.println(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.1 MB,击败了67.18% 的Java用户
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        if (postorder.length == 0) {
            return true;
        }
        // 根节点
        int root = postorder[postorder.length - 1];
        // 找到左子树中的根节点
        int center = 0;
        for (; center < postorder.length - 1; center++) {
            if (postorder[center] > root) {
                break;
            }
        }
        // 记录中间值
        int centerTemp = center;
        // 比较右子树
        // 如果右子树有比根节点小的那么觉得不可能是二叉搜索树
        for (; center < postorder.length - 1; center++) {
            if (postorder[center] < root) {
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (centerTemp > 0) {
            left = verifyPostorder(Arrays.copyOfRange(postorder, 0, centerTemp));
        }
        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (centerTemp < postorder.length - 1) {
            right = verifyPostorder(Arrays.copyOfRange(postorder, centerTemp, postorder.length - 1));
        }
        return (left && right);
    }
}
