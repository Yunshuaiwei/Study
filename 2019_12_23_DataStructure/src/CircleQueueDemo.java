import com.sun.media.sound.SoftTuning;

import javax.swing.*;
import javax.xml.bind.ValidationEvent;

/**
 * @author DELL
 * @Date 2019/12/24 10:19
 **/
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleArray c = new CircleArray(6);//队列有效数据最大为5
        c.addQueue(9);
        c.addQueue(10);
        c.addQueue(4);
        c.addQueue(3);
        c.showQueue();
        try {
            int queue = c.getQueue();
            System.out.println("取出的数据为:"+queue);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class CircleArray{
    private int maxSize;//数组的最大容量
    //front指向队列的第一个元素
    //front的初值为零0
    private int front;
    //rear指向队列的最后一个元素的后一个位置
    //rear的初值为0
    private int rear;
    private int [] arr;
    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=0;
        rear=0;
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满！");
            return;
        }
        //添加数据
        arr[rear]=n;
        //将rear后移，必须考虑取模
        rear=(rear+1)%maxSize;
    }
    //获取队列数据，即出队列
    public int getQueue(){
        if(isFull()){
            throw new RuntimeException("队列为空！");
        }
        //1.将front对应的值保留到一个临时变量
        //2.将front后移
        //3.将临时保留的值返回
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //求当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //打印队列数据
    public void showQueue(){
        if(isFull()){
            System.out.println("队列为空！");
        }
        for (int i = front; i <front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
}