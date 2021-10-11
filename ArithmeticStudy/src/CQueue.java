import java.util.Stack;

/**
 * @author yunshuaisei
 * @description: TODO
 * @date 2021/10/12 7:09
 **/
public class CQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        while (!st1.isEmpty()) {
            st2.add(st1.pop());
        }
        st1.add(value);
        while (!st2.isEmpty()) {
            st1.add(st2.pop());
        }
    }

    public int deleteHead() {
        if (!st1.isEmpty()) {
            return (int) st1.pop();
        }
        return -1;
    }

}
