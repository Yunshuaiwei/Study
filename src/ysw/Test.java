package ysw;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/14 8:08
 * @Version
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {

        ThreadDemo.A a = new ThreadDemo.A();
        ThreadDemo.B b = new ThreadDemo.B();

        Thread thread;
        for (int i = 0; i < 2; i++) {
            thread = new Thread(a);
            thread.start();
            thread = new Thread(b);
            thread.start();
        }
    }

}

class ThreadDemo {
    static int i = 1;

    /**
     * @return
     * @Param
     * @Date 13:49 2020/10/6
     * @Description: 该线程对变量进行加操作
     **/
    public static class A extends Thread {
        public void run() {
            for (int j = 0; j < 10; j++) {
                synchronized (ThreadDemo.class) {
                    i++;
                }
                System.out.println("线程" + Thread.currentThread().getName() + "A:" + i);
            }
        }
    }

    /**
     * @return
     * @Param
     * @Date 13:50 2020/10/6
     * @Description: 该线程对变量进行减操作
     **/
    public static class B extends Thread {
        public void run() {
            for (int j = 0; j < 10; j++) {
                synchronized (ThreadDemo.class) {
                    i--;
                }
                System.out.println("线程" + Thread.currentThread().getName() + "B:" + i);
            }
        }
    }
}