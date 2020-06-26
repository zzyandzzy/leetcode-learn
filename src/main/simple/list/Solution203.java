package main.simple.list;

import main.util.ListNode;

/**
 * main.simple.list
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/26 9:59 下午
 * @since 1.0
 */
public class Solution203 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 6, 3, 4, 5, 6);
        head1 = removeElements(head1, 6);
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.85%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 6.25%
     * 的用户
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
