package main.simple.list;

import main.util.ListNode;

/**
 * main.simple.list
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/23 10:21 上午
 * @since 1.0
 */
public class Solution234 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 2, 1);
        System.out.println(isPalindrome(head1));
    }

    /**
     * 快慢指针法
     * 第一步：快慢指针找到链表的中点
     * 第二步：将中点之后的子链表断开且反转
     * 第三步：比较判断前半部分和后半部分是否相等即可
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.67%
     * 的用户
     * 内存消耗：
     * 42.6 MB
     * , 在所有 Java 提交中击败了
     * 10.81%
     * 的用户
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        // 快慢指针找到链表的中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 将中点之后的子链表断开且反转,最后翻转完成之后pre指向反转链表的头节点
        while (slow != null) {
            ListNode p = slow.next;
            slow.next = pre;
            pre = slow;
            slow = p;
        }

        //3、前后链表进行比较，注意若为奇数链表，后半部分回比前部分多一个节点
        // 然而我们只比较相同长度的节点值，巧妙地避开这点判断
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }

        return true;
    }
}
