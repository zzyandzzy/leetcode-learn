package main.offer;

import main.util.ListNode;

import java.util.Arrays;
import java.util.Stack;

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
// Related Topics 链表
// 👍 106 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/3/5 21:30
 * @since 1.0
 */
public class Solution06 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1).add(3, 2);
        System.out.println(Arrays.toString(reversePrint3(root)));
    }

    /**
     * 还可以先计算链表的长度，然后再倒叙插入到数组中
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了57.24% 的Java用户
     *
     * @param head
     * @return
     */
    public static int[] reversePrint3(ListNode head) {
        // 第一步：计算链表的长度
        int len = 0;
        ListNode node = head;
        while (node != null) {
            ++len;
            node = node.next;
        }
        // 第二步：遍历链表，倒序插入数组
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

    /**
     * 递归本来就是栈的结构
     * 可以递归调用，但如果链表很长就可能会导致栈溢出{@link StackOverflowError}
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        return null;
    }

    /**
     * 从尾到头打印，首先想到翻转链表，但是翻转链表本身开销很大且打印只是只读操作
     * 再想到栈的数据结构，可以用栈实现。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 执行耗时:2 ms,击败了36.97% 的Java用户
     * 内存消耗:39 MB,击败了70.52% 的Java用户
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
