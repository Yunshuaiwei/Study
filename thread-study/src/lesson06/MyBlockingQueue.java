package lesson06;

/**
 * @author DELL
 * @Date 2020/3/28 9:46
 **/
public class MyBlockingQueue<E> {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            final int k=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 100; j++) {
                            queue.put(k*100+j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){
            int num=queue.take();
            System.out.println(num);
        }
    }

    private static int SUM;

    private static class Producer implements Runnable {

        @Override
        public void run() {
            SUM += 3;
            System.out.println("生产，库存为：" + SUM);
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            SUM--;
            System.out.println("消费，库存为：" + SUM);
        }
    }

    private Object[] items;
    private int takeIndex;//弹出元素的索引
    private int putIndex;//添加元素的索引
    private int size;//有效容量

    public MyBlockingQueue(int capacity) {
        items = new Object[capacity];
    }

    //添加元素
    public synchronized void put(E e) throws InterruptedException {
        while (size == items.length) {//达到上限是线程需要等待
            wait();
        }
        putIndex = (putIndex + 1) % items.length;//在索引的后一个位置进行添加操作，当
        // 长度超出数组长度时需要进行取模操作
        items[putIndex] = e;//将元素放入该位置
        size++;//有效元素长度++
        notifyAll();//唤醒wait
    }

    //取出元素
    public synchronized E take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        size--;
        notifyAll();
        E e=(E) items[takeIndex];
        takeIndex = (takeIndex + 1) % items.length;
        return e;
    }

}
