package main.medium.list;

import main.util.ListNode;
import main.util.TreeNode;
import main.util.TreeOperation;

/**
 * main.medium.list
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * -------0
 * ------/ \
 * -----3   9
 * ----/   /
 * ---10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/22 10:47 上午
 * @since 1.0
 */
public class Solution109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.add(-3, 0, 5, 9);
        TreeOperation.show(sortedListToBST(head));
    }

    /**
     * 快慢指针法
     *
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.8 MB
     * , 在所有 Java 提交中击败了
     * 13.33%
     * 的用户
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //设置快慢指针用来找到链表的中点，当fast指针走到尾时，slow指针指向链表中点，pre为slow中点的前一个节点
        ListNode pre = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        //将中点左边的链表断开
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);//二叉搜索的根节点为数组最中间的数
        root.left = sortedListToBST(head);//根节点的左子树连接链表的前半部分
        root.right = sortedListToBST(slow.next);//根节点的右子树连接链表的后半部分
        return root;
    }
}
