package main.interview;

import main.util.ListNode;

/**
 * main.interview
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 *  
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/4 7:44 下午
 * @since 1.0
 */
public class Solution0206 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 2, 3, 3, 1);
        System.out.println(isPalindrome(head1));
    }

    /**
     * 如果没有空间和时间复杂度的限制可以先把链表转换为数组，
     * 再用双指针判断是否回文就能解决
     * <p>
     * 方法一，先求出链表长度，然后得到链表长度中间值，
     * 然后反转head到链表中间值的节点
     * 再和链表中间值到尾节点相比较
     * <p>
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 50.11%
     * 的用户
     * 内存消耗：
     * 42.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode midNode = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;

        boolean palindrome = true;
        while (palindrome && curr2 != null) {
            if (curr1.val != curr2.val) {
                palindrome = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return palindrome;
    }

    /**
     * 反转链表
     */
    private static ListNode reverseLinked(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 快慢指针寻找中间节点
     */
    private static ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
