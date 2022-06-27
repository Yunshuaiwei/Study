package offer;

import java.util.Stack;

/**
 * @author yunshuaiwei
 * @className Day01
 * @description: TODO
 * @date 2022/6/27 9:22
 */
public class Day01 {


}

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}

class MinStack {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            Integer peek = stack2.peek();
            if (x < peek || peek.equals(x)) {
                stack2.push(x);
            }
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        }
        Integer pop = stack1.pop();
        Integer peek = stack2.peek();
        if (pop.equals(peek)) {
            stack2.pop();
        }
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        } else {
            return stack1.peek();
        }
    }

    public int min() {
        if (stack2.empty()) {
            return -1;
        }
        return stack2.peek();
    }
}
