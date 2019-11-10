package java1;

/**
 * @ProjectName Study
 * @ClassName ThreadTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 15:45
 * @Version 1.0
 **/
public class ThreadTest {
    public static void main(String[] args) {
        StringBuffer b1 = new StringBuffer();
        StringBuffer b2 = new StringBuffer();
        //线程一
        new Thread(() -> {
            synchronized (b1){
                b1.append("a");
                b2.append("1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b2){
                    b1.append("b");
                    b2.append("2");

                    System.out.println(b1);
                    System.out.println(b2);
                }
            }
        }).start();
        //线程二
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b2){
                    b1.append("c");
                    b2.append("3");try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b1){
                        b1.append("d");
                        b2.append("4");

                        System.out.println(b1);
                        System.out.println(b2);
                    }
                }
            }
        }).start();
    }
}
