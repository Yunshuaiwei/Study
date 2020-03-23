package lesson05;

/**
 * @author DELL
 * @Date 2020/3/23 9:56
 **/
public class BreadOperator {
    //上限100、下限0
    public static volatile int SUM;

    public static void main(String[] args) {
        //生产者生产面包
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(),"生产"+i).start();
        }
        //消费者消费面包
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(),"消费"+i).start();
        }
    }

    //生产者、内部类：每个面包师傅一次生产3个面包，每次生产20次
    private static class Producer implements Runnable{

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    synchronized (BreadOperator.class) {
                        while (SUM + 3 > 100) {
                            BreadOperator.class.wait();
                        }
                        SUM += 3;//生产面包
                        Thread.sleep(100);
                        BreadOperator.class.notifyAll();
                        System.out.println(Thread.currentThread().getName()+",生产面包，库存为："+SUM);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费者、一次消费一个，一直消费
    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                while (true){
                    synchronized (BreadOperator.class){
                        while (SUM==0){
                            BreadOperator.class.wait();
                        }
                        SUM--;
                        Thread.sleep(100);
                        //唤醒被wait阻塞的线程(随机唤醒一个线程)
                        BreadOperator.class.notifyAll();
                        System.out.println(Thread.currentThread().getName()+",消费面包，库存为："+SUM);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
