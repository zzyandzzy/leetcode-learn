package main.medium.list;

import main.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * main.medium.list
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4.2.1.3
 * 输出: 1.2.3.4
 * 示例 2：
 * <p>
 * 输入: -1.5.3.4.0
 * 输出: -1.0.3.4.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/24 9:18 上午
 * @since 1.0
 */
public class Solution147 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.add(5, 3, 1, 2);
        head1 = insertionSortList2(head1);
    }

    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 63.68%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 6.67%
     * 的用户
     * @param head
     * @return
     */
    public static ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        //注意：我们每次是将head的next节点进行插入排序的
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                //head的next节点值大于等于head的节点值，表示此次不需要进行插入排序，进行下一次循环
                head = head.next;
                continue;
            }
            pre = dummy;
            //寻找插入的位置，pre的next节点值大于等于head的next节点值时，那么pre的next节点就是我们的插入位置
            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }

            //将head的next节点插入到pre的next上
            ListNode cur = head.next;
            //head连接cur节点后面的链表部分
            head.next = cur.next;
            //cur连接pre的next节点，这样链表的顺序已经排好了，且链表还是完整的
            cur.next = pre.next;
            pre.next = cur;
        }

        return dummy.next;
    }

    /**
     * 暴力法，数组存节点先插入排序再连接起来
     * <p>
     * 执行用时：
     * 118 ms
     * , 在所有 Java 提交中击败了
     * 5.03%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 6.67%
     * 的用户
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        ListNode temp;
        // 插入排序
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i);
            if (temp.val < list.get(i - 1).val) {
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && list.get(j - 1).val > temp.val) {
                        list.set(j, list.get(j - 1));
                    } else {
                        list.set(j, temp);
                        break;
                    }
                }
            }
        }
        // 排序完再连接节点
        ListNode prev = list.get(0);
        node = prev;
        for (int i = 1; i < list.size(); i++) {
            prev.next = list.get(i);
            prev = prev.next;
        }
        prev.next = null;
        return node;
    }
}
