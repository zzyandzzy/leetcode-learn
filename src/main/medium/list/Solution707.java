package main.medium.list;

/**
 * main.other
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/3 10:13 上午
 * @since 1.0
 */
public class Solution707 {

    /**
     * 执行用时：
     * 19 ms
     * , 在所有 Java 提交中击败了
     * 6.31%
     * 的用户
     * 内存消耗：
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution707 obj = new Solution707();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        System.out.println(obj.get(5));
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }

    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;

    /**
     * Initialize your data structure here.
     */
    public Solution707() {
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node n = head;
        int i = 0;
        while (n != null && i != index) {
            n = n.next;
            i++;
        }
        return n == null ? -1 : n.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node current = new Node(val);
        if (head != null) {
            current.next = head;
        }
        head = current;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node current = new Node(val);
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = current;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        int i = 0;
        Node prev = null;
        Node n = head;
        while (i != index && n != null) {
            prev = n;
            n = n.next;
            i++;
        }
        if (i == 0) {
            addAtHead(val);
        } else if (prev != null) {
            Node current = new Node(val);
            current.next = prev.next;
            prev.next = current;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        int i = 0;
        Node prev = null;
        Node n = head;
        while (i != index && n != null) {
            prev = n;
            n = n.next;
            i++;
        }
        if (index == 0) {
            Node d = head;
            head = head.next;
            d.next = null;
            d = null;
        } else if (prev != null) {
            Node d = prev.next;
            if (d != null) {
                prev.next = prev.next.next;
                d.next = null;
                d = null;
            }
        }
    }
}
