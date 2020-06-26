package main.medium.list;

import main.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * main.medium.list
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/26 5:48 下午
 * @since 1.0
 */
public class Solution61 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 3, 4, 5);
        head1 = rotateRight2(head1, 2);
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 83.40%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 5.41%
     * 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        int count = k % len;
        if (count == 0) {
            return head;
        }
        //首尾相连，形成环形链表
        tail.next = head;
        int m = len - k % len;
        //tail移动m步，到达新头节点的前驱节点
        while (m-- > 0) {
            tail = tail.next;
        }
        //tail的next节点为新的头节点，顺便断开环形链表
        ListNode res = tail.next;
        tail.next = null;
        return res;
    }

    /**
     * 我先保存在数组里面移动了再生成链表
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 13.05%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 5.41%
     * 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        // 移动count次数组
        int count = k % list.size();
        for (int i = 0; i < count; i++) {
            ListNode temp = list.get(0);
            for (int j = 0; j < list.size(); j++) {
                if (j != list.size() - 1) {
                    ListNode pre = list.get(j + 1);
                    list.set(j + 1, temp);
                    temp = pre;
                } else {
                    list.set(0, temp);
                }
            }
        }
        // 把数组转换为链表
        head = list.get(0);
        node = head;
        for (int i = 1; i < list.size(); i++) {
            node.next = list.get(i);
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
