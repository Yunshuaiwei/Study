import com.sun.media.sound.SoftTuning;

/**
 * @author DELL
 * @Date 2020/1/28 12:49
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        stack.display();
    }
}
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    /**
     * 构造器
     * @param maxSize
     */
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        this.stack=new int[this.maxSize];
    }

    /**
     * 判断栈是否满
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isFull(){
        return top==maxSize-1;
    }
    /**
     * 压栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满！");
            return;
        }else{
            top++;
            stack[top]=value;
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        int value=stack[top];
        top--;
        return value;
    }

    /**
     * 遍历
     */
    public void display(){
        if(isEmpty()){
            System.out.println("栈为空！");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}