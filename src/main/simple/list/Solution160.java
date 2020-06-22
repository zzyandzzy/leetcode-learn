package main.simple.list;

import main.util.ListNode;

/**
 * main.simple.list
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，
 * 链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，
 * 相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，
 * 所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/22 10:10 上午
 * @since 1.0
 */
public class Solution160 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode nine = new ListNode(9);
        ListNode tow = new ListNode(2);
        ListNode four = new ListNode(4);
        four.next = null;
        tow.next = four;
        nine.next = tow;
        head1.next = nine;
        ListNode head2 = new ListNode(1);
        head2.next = tow;

        ListNode node = getIntersectionNode2(head1, head2);
    }

    /**
     * 快慢指针法
     * A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。
     * 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点
     * 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.97%
     * 的用户
     * 内存消耗：
     * 42.9 MB
     * , 在所有 Java 提交中击败了
     * 61.90%
     * 的用户
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    /**
     * 暴力法
     * <p>
     * 执行用时：
     * 814 ms
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗：
     * 42.5 MB
     * , 在所有 Java 提交中击败了
     * 78.57%
     * 的用户
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        while (l1 != null) {
            ListNode l2 = headB;
            while (l2 != null) {
                if (l1 == l2) {
                    return l1;
                }
                l2 = l2.next;
            }
            l1 = l1.next;
        }
        return null;
    }
}
