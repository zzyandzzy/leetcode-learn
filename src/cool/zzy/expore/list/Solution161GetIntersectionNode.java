package cool.zzy.expore.list;

//编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
//
// Related Topics 链表
// 👍 1146 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

import main.util.ListNode;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/6/3 11:08 下午
 * @since 1.0
 */
public class Solution161GetIntersectionNode {
    public static void main(String[] args) {
        ListNode publicNode = new ListNode(8, 4, 5);
        System.out.println(getIntersectionNode2(
                new ListNode(4, 1).add(publicNode),
                new ListNode(5, 0, 1).add(publicNode)).toString());
    }

    /**
     * 快慢指针法
     * A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。
     * 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点
     * 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     * <p>
     * info
     * 解答成功:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了85.54% 的Java用户
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    /**
     * 暴力法，在每一个A节点中找和B相等的节点
     * <p>
     * info
     * 解答成功:
     * 执行耗时:781 ms,击败了5.00% 的Java用户
     * 内存消耗:40.8 MB,击败了97.62% 的Java用户
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        while (nodeA != null) {
            ListNode nodeB = headB;
            while (nodeB != null) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
        }
        return null;
    }
}
