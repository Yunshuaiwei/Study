import java.util.Stack;

/**
 * @author yunshuaiwei
 * @className CQueue
 * @description: TODO
 * @date 2022/2/9 16:13
 */
public class CQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public CQueue() {
        this.stack1=new Stack<>();
        this.stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }
}
