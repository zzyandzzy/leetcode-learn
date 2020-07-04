package main.medium.list;

import main.util.ListNode;

/**
 * main.medium.list
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/4 7:22 下午
 * @since 1.0
 */
public class Solution328 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 3, 4, 5, 6);
        head1 = oddEvenList(head1);
    }

    /**
     * 好像可以用双指针解决
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 8.70%
     * 的用户
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        if (node2 == null) {
            return head;
        }
        ListNode l1 = node1;
        ListNode l2 = node2;
        while (l1 != null && l1.next != null || l2 != null && l2.next != null) {
            if (l1 != null && l1.next != null) {
                l1.next = l1.next.next;
                if (l1.next != null) {
                    l1 = l1.next;
                }
            }
            if (l2 != null && l2.next != null) {
                l2.next = l2.next.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            l1.next = node2;
        }
        return node1;
    }

    /**
     * 官方解法
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList2(ListNode head) {
        // 特判：头结点为 null，返回null
        // head是奇链表的头
        if (head == null) {
            return null;
        }

        // odd是奇链表的当前节点，先初始化为head（初始化为奇链表头）
        ListNode odd = head;
        // even是偶链表的当前节点，初始化为第二个节点也就是head.next
        ListNode even = head.next;
        // evenHead是偶链表的头节点，初始化为链表第二个节点（初始化为奇链表头的下一个节点）
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // 这里while退出判断条件还是画图一下才能理解（也就是官方题解的STEP2）
            odd.next = even.next;  // 相当于odd.next = odd.next.next(跳过一个偶数节点)
            odd = odd.next;        // odd向前前进一位
            even.next = odd.next;   // 奇链表的下一个节点就是偶链表的节点
            even = even.next;       // even向前前进一位
        }
        // while条件结束，把偶链表头指针拼接到奇链表的最后
        odd.next = evenHead;
        // 返回奇链表头就是返回整个奇偶排序后的链表
        return head;
    }
}
