package lesson02;

/**
 * @author DELL
 * @Date 2020/3/8 10:00
 **/
public class ThreadDemo {
    static final int NUM = 5;

    private static void concurrency() {
        long count = 0;
        while (count < 1000000000) {
            count++;
        }
    }

    /**
     * 串行
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            concurrency();
        }
        long end = System.currentTimeMillis();
        System.out.printf("串行执行时间为：%d", end - start);
    }

    /**
     * 并发
     */
    private static void parallel() {
        long start = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                concurrency();
            }
        }).start();
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.printf("并行执行时间为：%d", end - start);
        System.out.println();
    }

    public static void main(String[] args) {
        serial();
        System.out.println();
        parallel();
    }
}
