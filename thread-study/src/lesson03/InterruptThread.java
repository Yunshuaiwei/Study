package lesson03;

/**
 * @author DELL
 * @Date 2020/3/13 10:49
 **/
public class InterruptThread {
    public static void testInterrupt(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        });
        t.start();
        //将线程中断，但是否中断由线程自己决定
        t.interrupt();
    }
    public static void test2() throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    //打印标志位，判断线程是否被中断
                    System.out.println(i+"="+Thread.currentThread().isInterrupted());
                }
//                while(!Thread.currentThread().isInterrupted()){
//                    System.out.println(Thread.currentThread().getName());
//                }
            }
        });
        t.start();
        t.interrupt();
    }


    public static void test3(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //调用sleep/join/wait阻塞方法时，如果线程被中断状态，则直接抛出异常
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.interrupt();
    }
    public static void test4(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i+"="+ Thread.interrupted());//返回中断标志位，并重置标志位
                }
            }
        });
        t.start();
        t.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        test4();
    }
}
