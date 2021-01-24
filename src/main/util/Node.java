package main.util;

/**
 * main.util
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/6 9:41 上午
 * @since 1.0
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;


    public Node(int val) {
        this.val = val;
    }
}
