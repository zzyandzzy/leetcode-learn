package main.offer;
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 186 👎 0

import java.util.Stack;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/3/6 22:41
 * @since 1.0
 */
public class Solution09 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int size = 0;

    public static void main(String[] args) {
        Solution09 solution08 = new Solution09();
        System.out.println(solution08.deleteHead());
        solution08.appendTail(5);
        solution08.appendTail(2);
        System.out.println(solution08.deleteHead());
        System.out.println(solution08.deleteHead());
    }

    /**
     * stack1           stack2
     * push 5
     * 5
     * -----------------------
     * pop              push 5
     * -                5
     * push 2
     * 2                5
     * push 5           pop
     * 5
     * 2
     *
     * @param value 值
     */
    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    /**
     * @return int
     */
    public int deleteHead() {
        if (size == 0) return -1;
        size--;
        return stack1.pop();
    }
}
