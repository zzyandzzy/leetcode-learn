package main.simple.list;

/**
 * main.simple.list
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/19 9:20 上午
 * @since 1.0
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode add(int... next) {
        ListNode q = this;
        for (int i = 0; i < next.length; i++) {
            q.next = new ListNode(next[i]);
            q = q.next;
        }
        return this;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
