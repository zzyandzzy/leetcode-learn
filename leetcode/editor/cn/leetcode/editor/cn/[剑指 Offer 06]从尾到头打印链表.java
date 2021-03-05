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
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
