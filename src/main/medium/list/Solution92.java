package main.medium.list;

import main.util.ListNode;

/**
 * main.medium.list
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1.2.3.4.5.NULL, m = 2, n = 4
 * 输出: 1.4.3.2.5.NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/23 4:48 下午
 * @since 1.0
 */
public class Solution92 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(2, 3, 4, 5);
        head1 = reverseBetween(head1, 2, 4);
    }

    /**
     * 双指针法，pre先走m-1步到达位置m的前驱节点，pre不动，然后令cur等于pre->next也就是位置m的起始节点（不变），
     * 将[m+1,n]这段链表由前至后的插入到位置m的前面，也就是pre的后面
     * 换句话说：我们每次循环就是将cur的next节点插入到pre的后面，这样插了n-m次后，就完成反转了
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.2 MB
     * , 在所有 Java 提交中击败了
     * 8.70%
     * 的用户
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        //设置哑节点的好处：在m=1时，我们也有前驱节点，也可以将cur的next节点依次插入到pre的后面
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // pre为m节点的前一个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // m节点
        ListNode cur = pre.next;
        //每次循环将nxt节点插入到pre的后面
        for (int i = m; i < n; i++) {
            ListNode nxt = cur.next;
            //cur将nxt节点后面的链表连接起来
            cur.next = nxt.next;
            //将nxt插入到pre后面
            nxt.next = pre.next;
            pre.next = nxt;
        }
        return dummy.next;
    }
}
