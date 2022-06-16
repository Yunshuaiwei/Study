package common;

/**
 * @author yunshuaiwei
 * @className ListNode
 * @description: TODO
 * @date 2022/2/10 18:56
 */
public class ListNode<V> {
    public V val;
    public ListNode<V> next;

    public ListNode(V x) {
        val = x;
    }

    public ListNode(V x,ListNode<V> next){
        this.val=x;
        this.next=next;
    }
}
