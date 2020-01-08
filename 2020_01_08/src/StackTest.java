/**
 * @author DELL
 * @Date 2020/1/8 10:17
 **/
public class StackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(5);
        System.out.println(myStack.peek());
        myStack.pop();
        try {
            System.out.println(myStack.peek());
        }catch (Exception e){
            e.printStackTrace();
        }

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
class MyStack{
    Node head=null;
    public MyStack(){
        this.head=null;
    }
    public void push(int x){
        Node node = new Node(x);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=head;
            head=node;
        }
    }
    public int peek(){
        if(head==null){
            throw new RuntimeException("Stack is NUll!");
        }
        return head.val;
    }
    public void pop(){
        if(head==null){
            throw new RuntimeException("Stack is NUll!");
        }
        head=head.next;
    }
    public boolean empty(){
        if(head==null){
            return true;
        }
        return false;
    }
}