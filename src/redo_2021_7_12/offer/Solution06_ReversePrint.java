package redo_2021_7_12.offer;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import main.util.ListNode;

import java.util.Arrays;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/13 11:16 上午
 * @since 1.0
 */
public class Solution06_ReversePrint {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, 3, 2);
        System.out.println(Arrays.toString(reversePrint2(head1)));
    }

    /**
     * 还想到了将链表反转，然后输出
     * 这种方法的好处的实际上反转了链表。。。😒😒😒但对于本题没必要！
     * 时间复杂度是 O(n)
     * 空间复杂度是 O(n)
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode next = head;
        ListNode current = null;
        int len = 0;
        while (next != null) {
            ListNode node = next;
            next = next.next;
            node.next = current;
            current = node;
            len++;
        }
        int[] arr = new int[len];
        next = current;
        int i = 0;
        while (next != null) {
            arr[i++] = next.val;
            next = next.next;
        }
        return arr;
    }

    /**
     * 既然用数组返回那么就很好办了，先求出链表长度，再创建数组，再遍历链表就可以了
     * 时间复杂度是 O(n)
     * 空间复杂度是 O(n)
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了44.55% 的Java用户
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] arr = new int[len];
        node = head;
        int i = 0;
        while (node != null) {
            arr[len - i - 1] = node.val;
            node = node.next;
            i++;
        }
        return arr;
    }
}
