package ThreadTest;

/**
 * @ProjectName Study
 * @ClassName ThreadDemo
 * Description
 * @Auther YunSW
 * @Date 2019/11/7 13:24
 * @Version 1.0
 *练习：创建两个分线程，其中一个线程遍历100以内的奇数，另一个线程遍历100以内的偶数
 *
 *
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1=new MyThread1();
        MyTread2 t2=new MyTread2();

        t1.start();
        t2.start();
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class MyTread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <100 ; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}