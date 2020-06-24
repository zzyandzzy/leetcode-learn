package main.medium.list;

import main.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * main.medium.list
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/24 8:58 上午
 * @since 1.0
 */
public class Solution143 {
    public static void main(String[] args) {

    }

    /**
     * 双指针，首尾指针法
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 30.78%
     * 的用户
     * 内存消耗：
     * 42 MB
     * , 在所有 Java 提交中击败了
     * 9.09%
     * 的用户
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> arr = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            arr.add(node);
            node = node.next;
        }
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            // 首尾组合连接
            arr.get(i).next = arr.get(j);
            ++i;
            if (i == j) {
                // 表示有偶数个节点，重排后相遇了，需要退出
                break;
            }
            arr.get(j).next = arr.get(i);
            j--;
        }
        arr.get(i).next = null;
    }
}
