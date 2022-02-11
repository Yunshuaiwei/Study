package common;

/**
 * @author yunshuaiwei
 * @className Node
 * @description: TODO
 * @date 2022/2/10 19:47
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}