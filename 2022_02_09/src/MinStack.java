import java.util.Objects;
import java.util.Stack;

/**
 * @author yunshuaiwei
 * @className MinStack
 * @description: TODO
 * @date 2022/2/9 16:28
 */
public class MinStack {
    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.empty()) {
            stack2.push(x);
        } else {
            Integer peek = stack2.peek();
            if (x < peek || peek.equals(x)) {
                stack2.push(x);
            }
        }
    }

    public void pop() {
        if (stack1.empty()) {
            return;
        }
        Integer pop = stack1.pop();
        if (Objects.equals(stack2.peek(), pop)) {
            stack2.pop();
        }
    }

    public int top() {
        if (stack1.empty()) {
            return -1;
        }
        return stack1.peek();
    }

    public int min() {
        if (stack2.empty()) {
            return -1;
        }
        return stack2.peek();
    }
}
