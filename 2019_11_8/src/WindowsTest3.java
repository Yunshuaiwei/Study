/**
 * @ProjectName Study
 * @ClassName WindowsTest3
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 15:03
 * @Version 1.0
 **/
public class WindowsTest3 {
    public static void main(String[] args) {
        test t1 = new test();
        test t2 = new test();
        test t3 = new test();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
class test extends Thread {
    private static int ticket=100;
    @Override
    public void run() {
        while(true){
            show();
        }
    }
    private static synchronized void show(){//同步监视器为当前类的对象；即test.class
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+"卖票，票号为："+ticket);
            ticket--;
        }
    }
}