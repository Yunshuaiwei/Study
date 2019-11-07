package ThreadTest;

/**
 * @ProjectName Study
 * @ClassName WindowsTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/7 18:57
 * @Version 1.0
 **/
public class WindowsTest {
    public static void main(String[] args) {
        Windows windows = new Windows();

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
class Windows implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}