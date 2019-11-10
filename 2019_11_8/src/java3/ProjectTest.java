package java3;

import java.security.PrivateKey;

/**
 * @ProjectName Study
 * @ClassName ProjectTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 17:15
 * @Version 1.0
 **/
public class ProjectTest {
    public static void main(String[] args) {
        Clerk c1 = new Clerk();

        Producer p1 = new Producer(c1);
        p1.setName("生产者1");

        Consumer con = new Consumer(c1);
        con.setName("消费者1");
        p1.start();
        con.start();
    }
}
class Clerk{
    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品！");
        }else{

        }
    }
    //消费产品
    public synchronized void consumeProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+"：开始消费第"+productCount+"个产品！");
            productCount--;
        }else{

        }
    }
}
class Producer extends Thread{//生产者
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始生产产品......");

        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Consumer extends Thread{//消费者
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始消费产品......");

        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}