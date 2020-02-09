/**
 * @ProjectName Study
 * @ClassName WindowsTest2
 * Description
 * @Auther YunSW
 * @Date 2019/11/8 12:03
 * @Version 1.0
 **/
public class WindowsTest2 {
    public static void main(String[] args) {
        Windows2 windows = new Windows2();

        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows2 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            show();
        }
    }

    /**
     * synchronized修饰方法
     */
    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}