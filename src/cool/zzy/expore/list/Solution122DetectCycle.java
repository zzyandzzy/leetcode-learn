package cool.zzy.expore.list;

import main.util.ListNode;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/4/25 22:24
 * @since 1.0
 */
public class Solution122DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(-4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = a;
        ListNode node = detectCycle(head);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return null;
        }
        ListNode ret = head;
        while (ret != slow) {
            ret = ret.next;
            slow = slow.next;
        }
        return ret;
    }
}
