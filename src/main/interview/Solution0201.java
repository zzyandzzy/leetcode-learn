package main.interview;

import main.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * main.interview
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/18 7:43 下午
 * @since 1.0
 */
public class Solution0201 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        head = removeDuplicateNodes2(head);
    }

    /**
     * 冒泡排序。。。
     * info
     * 解答成功:
     * 执行耗时:406 ms,击败了8.80% 的Java用户
     * 内存消耗:40.3 MB,击败了100.00% 的Java用户
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes2(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode q = p;
            while (q.next != null) {
                if (q.next.val == p.val) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
        return head;
    }

    private static Set<Integer> set = new HashSet<>();

    /**
     * HashSet。。。不过使用了HashSet就有点像作弊，管他的先做出来再说。。。
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null)//说明到了链表尾端
            return null;
        if (!set.contains(head.val)) {//这个值第一次出现
            set.add(head.val);//set中加入这个值，防止再次出现
            head.next = removeDuplicateNodes(head.next);//保留此节点，对下一个节点继续验证
            return head;
        } else {//这个值不是第一次出现
            //当前节点不要，返回对下一个节点的验证，注意这里返回的也是一个链表
            // 的一部分，返回的节点会直接挂到上次个只出现一次的节点下面。如果说
            //链表不为空，呢么一定会有至少一个节点在上面，也就是满足过if条件的，
            //那么根据if中的代码，head.next就是这里返回的。
            return removeDuplicateNodes(head.next);
        }
    }
}
