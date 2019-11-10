package java2;

/**
 * @ProjectName Study
 * @ClassName CommunicationTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 16:24
 * @Version 1.0
 *
 * wait()方法：一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * notify():执行此方法会唤醒被wait的线程
 * notifyAll()：执行此方法会唤醒所有被wait的线程
 **/
public class CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        Thread t3 = new Thread(n1);

        t1.setName("线程A");
        t2.setName("线程B");
        t3.setName("线程C");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Number implements Runnable{
    private int number=1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notifyAll();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}