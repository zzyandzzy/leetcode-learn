package main.medium.list;

import main.util.ListNode;

/**
 * main.medium.list
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/22 9:21 上午
 * @since 1.0
 */
public class Solution19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2, 3, 4, 5);
        ListNode h = removeNthFromEnd2(head, 3);
    }

    /**
     * 快慢指针法
     * 快指针先循环n次，然后再和慢指针一起走
     * 走到最后慢指针的next就是要删除的节点
     * 假如：n = 3
     * head--->1--->2--->3--->4--->5--->null
     * 初始条件:slow----------fast
     * 快指针到尾部:slow-----------fast
     * 慢指针slow->next 3就为要删除的节点
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 5.43%
     * 的用户
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 说明要删除的节点为第一个节点
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 暴力法，先求出长度再删除
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 5.43%
     * 的用户
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (n == 0) {
            return head;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (n == len) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
            return head;
        }
        node = head;
        int i = 0;
        while (node != null) {
            i++;
            if (len - n <= i) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
}
