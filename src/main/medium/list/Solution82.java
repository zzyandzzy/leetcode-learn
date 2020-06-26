package main.medium.list;

import main.util.ListNode;

/**
 * main.medium.list
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/26 9:09 下午
 * @since 1.0
 */
public class Solution82 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 3, 3, 4, 4, 5);
        head1 = deleteDuplicates(head1);
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 92.15%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 6.67%
     * 的用户
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        /*
         *         1->2->3->3->4->4->5
         * 第1轮: p h                      h.val != h.next.val
         * 第2轮:   p  h                   h.val != h.next.val
         * 第3轮:      p  h                h.val == h.next.val
         *   3.1:     p.next-> h.next     h.val != h.next.val
         * 第4轮:      p           h       h.val == h.next.val
         *   4.1:     p.next->     h.next  h.val != h.next.val
         * 第5轮:                     p    h.val != h.next.val
         *
         */
        while (head != null && head.next != null) {
            //head与head.next节点值不相等，pre指向head，也就是指向不重复值
            if (head.val != head.next.val) {
                pre = head;
                head = head.next;
            } else {
                //head为重复值子链表的最后一个节点，比如1.1.1.2的最后一个1
                while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                //pre连接重复值子链表的之后第一个节点
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
