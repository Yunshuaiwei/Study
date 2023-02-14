import java.util.Stack;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/7 16:27
 */
public class CQueue {
    Stack<Integer> stack;
    Stack<Integer> stack1;

    public CQueue() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            while (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
        }
        if (!stack1.isEmpty()) {
            return stack1.pop();
        } else {
            return -1;
        }
    }
}
