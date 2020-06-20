package main.offer;

import java.util.LinkedList;

/**
 * main.offer
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/20 9:46 上午
 * @since 1.0
 */
public class Solution09 {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public Solution09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        solution09.stack1.push(1);
        solution09.stack1.push(2);
        solution09.stack1.push(3);
        System.out.println(solution09.stack1.pop());
        System.out.println(solution09.stack1.pop());
        System.out.println(solution09.stack1.pop());
    }

    /**
     * 一个栈入，另外一个栈出
     * stack1 <--- 1
     * stack1 ---> 1 ---> stack2
     * stack2 ---> 1 ---> return
     * 如果栈加入的是两个元素
     * stack1 <--- 1
     * stack1 <--- 2
     * ----------------
     * 此时栈stack1情况：
     * 2 栈顶
     * 1 栈底
     * ----------------
     * stack1 ---> 2 ----> stack2
     * stack1 ---> 1 ----> stack2
     * ----------------
     * 此时栈stack2情况：
     * 1 栈顶
     * 2 栈底
     * ----------------
     * stack2 ---> 1 ---> return
     *
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
