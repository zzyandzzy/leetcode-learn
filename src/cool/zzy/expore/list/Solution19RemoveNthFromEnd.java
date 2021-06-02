package cool.zzy.expore.list;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1395 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import main.util.ListNode;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/6/2 9:40 下午
 * @since 1.0
 */
public class Solution19RemoveNthFromEnd {
    public static void main(String[] args) {
        System.out.println(removeNthFromEnd2(new ListNode(1).add(2, 3, 4, 5), 2));
        System.out.println(removeNthFromEnd2(new ListNode(1).add(2, 3, 4, 5), 1));
        System.out.println(removeNthFromEnd2(new ListNode(1).add(2, 3, 4, 5), 5));
    }


    /**
     * 快慢指针求解
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 第一遍先求得链表长度
     * 第二遍再删除节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len == n) {
            if (head.next != null) {
                return head.next;
            }
            return head;
        }
        int i = 0;
        node = head;
        while (node != null) {
            i++;
            if (i == len - n) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
}
