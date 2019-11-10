package java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName Study
 * @ClassName LockTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 16:04
 * @Version 1.0
 **/
public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口A");
        t2.setName("窗口B");
        t3.setName("窗口C");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window implements Runnable{
    private int ticket=100;
    //1、实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                //2、调用lock()
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+"卖票，票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3、调用解锁方法：unlock
                lock.unlock();
            }
        }
    }
}