package java3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName Study
 * @ClassName ThreadPool
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 18:20
 * @Version 1.0
 **/
public class ThreadPool {
    public static void main(String[] args) {
        //1、提供指定线程数量的线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //2、执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
//        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
        service.execute(new NumberThread());//适合Runnable
        service.execute(new NumberThread1());
//        service.submit(new NumberThread());//适合适用于Callable
        //关闭线程池
        //3、关闭线程池
        service.shutdown();
    }
}
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class  NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}