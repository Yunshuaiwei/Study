package lesson01;

/**
 * @author DELL
 * @Date 2020/3/4 19:58
 **/
public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
