package main.util;

/**
 * main.simple.list
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 9:20 上午
 * @since 1.0
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode add(int... next) {
        ListNode q = this;
        for (int i = 0; i < next.length; i++) {
            q.next = new ListNode(next[i]);
            q = q.next;
        }
        return this;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        ListNode node = this;
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
