/**
 * @ProjectName Study
 * @ClassName ThreadTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/7 11:37
 * @Version 1.0
 * 多线程的创建，方法一：继承于Thread类
 * 1、创建一个继承于Thread类的子类
 * 2、重写Thread类的run（）
 * 3、创建Thread类的子类的对象
 * 4、通过对象调用start（）
 *
 *
 *
 **/
public class ThreadTest {
    public static void main(String[] args) {
        //3、创建Thread类的子类对象
        MyThread t1 = new MyThread();
        //4、调用start（）方法:① 启动当前线程  ② 调用当前线程的run（）方法
        t1.start();
        MyThread t2=new MyThread();
        t2.start();
        for(int i=1;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i+"--main()--");
            }
        }
    }
}
//1、创建一个继承于Thread类的子类
class MyThread extends  Thread{
    //2、重写run（）方法-->将此线程执行的操作声明在其中

    @Override
    public void run() {
        //100以内的偶数
        for(int i=1;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}