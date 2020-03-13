package lesson03;

/**
 * @author DELL
 * @Date 2020/3/13 17:19
 **/
public class UnsafeThread {
    private static final int NUM=20;
    private static final int COUNT=10000;
    static int sum=0;
    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        sum++;
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(sum);
    }
}
