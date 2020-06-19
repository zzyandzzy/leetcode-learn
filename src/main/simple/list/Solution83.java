package main.simple.list;

import main.util.ListNode;

/**
 * main.simple.list
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 10:07 上午
 * @since 1.0
 */
public class Solution83 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.add(1, 2);
        ListNode node1 = deleteDuplicates(head1);

        ListNode head2 = new ListNode(1);
        head2.add(1, 2, 3, 3);
        ListNode node2 = deleteDuplicates(head1);
    }

    /**
     * 在添加下一个元素之前检查下一个元素的值和当前的值是否相同
     * info
     * 解答成功:
     * 执行耗时:1 ms,击败了73.30% 的Java用户
     * 内存消耗:39.2 MB,击败了5.97% 的Java用户
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
