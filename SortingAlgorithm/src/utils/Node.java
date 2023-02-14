package utils;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/13 16:13
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