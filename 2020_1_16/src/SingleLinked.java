/**
 * @author DELL
 * @Date 2020/1/16 18:06
 **/
public class SingleLinked {
    public static void main(String[] args) {
        MyLinked myLinked = new MyLinked();
        myLinked.addVal(1);
        myLinked.addVal(2);
        myLinked.addVal(3);
        myLinked.indexAdd(0,0);
        myLinked.indexAdd(4,4);
        myLinked.deleteNode(0);
        myLinked.display();
    }
}
class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
class MyLinked{
    Node head=null;

    /**
     * 尾插
     * @param val
     */
    public void addVal(int val){
        Node node = new Node(val);
        if(head==null){
            head=node;
        }else{
            Node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    public void tailAdd(int val){
        Node node = new Node(val);
        Node cur=head;
        if (head != null) {
            node.next = cur;
        }
        head = node;
    }
    /**
     * 遍历
     */
    public void display(){
        Node cur=head;
        if(cur==null){
            return;
        }
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    /**
     * 链表的长度
     * @return
     */
    public int length(){
        Node cur=head;
        int length=0;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }
    private Node beforeNode(int index){
        Node cur=head;
        while(index-1>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    /**
     * 任意位置添加数据
     * @param index
     * @param val
     */
    public void indexAdd(int index,int val){
        Node node = new Node(val);
        if(index==0){
            tailAdd(val);
            return;
        }
        Node node1 = beforeNode(index);
        Node newNext=node1.next;
        node1.next=node;
        node.next=newNext;
    }

    /**
     * 删除节点
     * @param index
     * @return
     */
    public boolean deleteNode(int index){
        Node cur = beforeNode(index);
        if(cur==null){
            System.out.println("没有此节点！");
            return false;
        }
        if(index==0){
            head=head.next;
            return true;
        }
        cur.next=cur.next.next;
        return true;
    }
}