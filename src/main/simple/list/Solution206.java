package main.simple.list;

import main.util.ListNode;

/**
 * main.simple.list
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/23 5:18 下午
 * @since 1.0
 */
public class Solution206 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 3, 4, 5);
        head1 = reverseList(head1);
    }

    /**
     * 存储前面的值的指针prev
     * 当前指针cur
     * 每次循环
     * 令nxt指针等于cur->next，这一步是保存后面的指针，因为等下要直接替换cur->next
     * 令cur->next = prev，直接替换cur->next为prev，实现了反转
     * 令prev = cur，保存前面反转的指针
     * 令cur = nxt，进行下一步反转
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.6 MB
     * , 在所有 Java 提交中击败了
     * 5.06%
     * 的用户
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
