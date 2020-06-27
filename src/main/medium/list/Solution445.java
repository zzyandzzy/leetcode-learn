package main.medium.list;

import main.util.ListNode;

import java.util.Stack;

/**
 * main.medium.list
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/27 9:54 上午
 * @since 1.0
 */
public class Solution445 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
        head1.add(2, 4, 3);
        ListNode head2 = new ListNode(5);
        head2.add(6, 4);
        head1 = addTwoNumbers2(head1, head2);
    }

    /**
     * 双栈法，把两个链表的数据分别压入栈
     * (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 栈s1: 3 -> 4 -> 2 -> 7
     * 栈s2: 4 -> 6 -> 5
     * 相加: 7 -> 0 -> 8 -> 7
     * <p>
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 81.03%
     * 的用户
     * 内存消耗：
     * 40 MB
     * , 在所有 Java 提交中击败了
     * 95.83%
     * 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                s1.push(node1.val);
                node1 = node1.next;
            }
            if (node2 != null) {
                s2.push(node2.val);
                node2 = node2.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (!s1.empty() || !s2.empty()) {
            int sum = 0;
            if (!s1.empty()) {
                sum = s1.pop();
            }
            if (!s2.empty()) {
                sum += s2.pop();
            }
            sum += carry;
            carry = sum / 10;
            // 头插法插入节点
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    /**
     * 先把两个链表翻转再相加
     * <p>
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 65.26%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 95.83%
     * 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 存储链表数据
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                sb1.append(node1.val);
                node1 = node1.next;
            }
            if (node2 != null) {
                sb2.append(node2.val);
                node2 = node2.next;
            }
        }
        sb1.reverse();
        sb2.reverse();
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        int len = Math.max(s1.length(), s2.length());
        int c = 0;
        // 存储相加结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int sum = 0;
            if (i < s1.length()) {
                sum = s1.charAt(i) - '0';
            }
            if (i < s2.length()) {
                sum += s2.charAt(i) - '0';
            }
            sum += c;
            if (sum >= 10) {
                c = sum / 10;
                sb.append(sum % 10);
            } else {
                c = 0;
                sb.append(sum);
            }
        }
        if (c != 0) {
            sb.append(c);
        }
        // 翻转
        sb.reverse();
        String s = sb.toString();
        // 构建新链表
        ListNode dummy = new ListNode(s.charAt(0) - '0');
        ListNode node = dummy;
        for (int i = 1; i < s.length(); i++) {
            node.next = new ListNode(s.charAt(i) - '0');
            node = node.next;
        }
        return dummy;
    }
}
