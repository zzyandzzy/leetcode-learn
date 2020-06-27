package main.simple.list;

import main.util.ListNode;

/**
 * main.simple.list
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 * <p>
 * 提示：
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/23 10:42 上午
 * @since 1.0
 */
public class Solution876 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 3, 4, 5);
        head1 = middleNode(head1);
        ListNode head2 = new ListNode(1);
        head2.add(2, 3, 4, 5, 6);
        head2 = middleNode(head2);
        ListNode head3 = new ListNode(1);
        head3 = middleNode(head3);
    }

    /**
     * 快慢指针
     * 快指针走2步
     * 慢指针走1步
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37 MB
     * , 在所有 Java 提交中击败了
     * 6.25%
     * 的用户
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.next == null) {
                return slow.next;
            } else if (fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}