import org.junit.Test;

/**
 * @author DELL
 * @Date 2019/12/23 17:38
 **/
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(6);
        queue.addQueue(7);
        queue.addQueue(10);
        queue.addQueue(24);
        queue.addQueue(4);
        queue.addQueue(8);
        int q = queue.getQueue();
        int q1 = queue.getQueue();
        System.out.println(q);
        System.out.println(q1);
    }
}
class ArrayQueue{
    //数组的容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //存放数据，模拟队列
    private int[] arr;
    public ArrayQueue(int arrMaxSize){
        this.maxSize=arrMaxSize;
        arr=new int[this.maxSize];
        this.front=-1;//指向队列头部
        this.rear=-1;//指向队列尾
    }
    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据
    public void addQueue(int n){
        //队列是否为满
        if(isFull()){
            System.out.println("队列已满，不能添加数据！");
            return;
        }
        rear++;//让rear后移
        arr[rear]=n;
    }
    //获取队列数据
    public int getQueue(){
        //判断队列是否为空
        if(isFull()){
            System.out.println("队列为空！");
        }
        front++;//front后移
        return arr[front];
    }
    //打印队列数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空！");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}