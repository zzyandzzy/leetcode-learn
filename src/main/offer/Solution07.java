package main.offer;

import main.util.TreeNode;
import main.util.TreeOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * main.offer
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * -----3
 * ----/ \
 * ---9  20
 * -----/  \
 * ----15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 5:55 下午
 * @since 1.0
 */
public class Solution07 {
    public static void main(String[] args) {
        TreeOperation.show(buildTree2(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    /**
     * 递归的方法
     * 执行用时：
     * 31 ms
     * , 在所有 Java 提交中击败了
     * 5.56%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        // 把数组转换成链表
        List<Integer> l1 = new ArrayList<>();
        for (int i : preorder) {
            l1.add(i);
        }
        List<Integer> l2 = new ArrayList<>();
        for (int i : inorder) {
            l2.add(i);
        }
        return buildTree2(l1, l2);
    }

    public static TreeNode buildTree2(List<Integer> preorder, List<Integer> inorder) {
        // 递归结束的条件
        if (preorder.size() == 0) {
            return null;
        }
        // root节点
        TreeNode root = new TreeNode(preorder.get(0));
        int index = inorder.indexOf(root.val);
        root.left = buildTree2(preorder.subList(1, 1 + index), inorder.subList(0, index));
        root.right = buildTree2(preorder.subList(1 + index, preorder.size()), inorder.subList(1 + index, inorder.size()));
        return root;
    }

    /**
     * 根据二叉树的性质，知道二叉树的前序遍历和中序遍历就可以得到这颗树
     * 首先，前序遍历的第一个为root节点，然后在中序遍历里面找root节点，可以分为左右两颗子树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1,
                inorder, 0, length - 1, indexMap);
    }

    /**
     * 构造二叉树
     *
     * @param preorder
     * @param preorderStart
     * @param preorderEnd
     * @param inorder
     * @param inorderStart
     * @param inorderEnd
     * @param indexMap
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                                     int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {

        if (preorderStart > preorderEnd) {
            return null;
        }
        // 当前root节点的值
        int rootVal = preorder[preorderStart];
        TreeNode rootTree = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return rootTree;
        } else {
            // 构造子树
            // 要知道preorder的结束位置就需要去inorder
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            rootTree.left = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                    inorder, inorderStart, rootIndex - 1, indexMap);
            rootTree.right = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd, indexMap);
        }
        // 返回
        return rootTree;
    }

}
