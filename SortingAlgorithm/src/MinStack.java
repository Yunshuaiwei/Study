import java.util.Stack;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/7 16:34
 */
public class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty()) {
            Integer peek = stack2.peek();
            if (x < peek || peek.equals(x)) {
                stack2.push(x);
            }
        } else {
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.isEmpty()){
            return;
        }
        Integer pop = stack1.pop();
        if (pop.equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        if (stack1.isEmpty()){
            return -1;
        }
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()){
            return -1;
        }
        return stack2.peek();
    }
}
