package main.offer;

import java.util.Stack;

/**
 * main.offer
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 *  
 * <p>
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/19 09:59
 * @since 1.0
 */
public class Solution30 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：
     * 21 ms
     * , 在所有 Java 提交中击败了
     * 31.21%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     */
    class MinStack {
        Stack<Integer> s1, s2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            if (s2.isEmpty() || x <= min()) {
                s2.push(x);
            }
            s1.push(x);
        }

        public void pop() {
            if (s1.isEmpty() || s2.isEmpty()) {
                return;
            }
            if (s1.pop().equals(min())) {
                s2.pop();
            }
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }
}
