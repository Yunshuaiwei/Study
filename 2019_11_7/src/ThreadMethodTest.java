/**
 * @ProjectName Study
 * @ClassName ThreadMethodTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/7 13:46
 * @Version 1.0
 *线程的优先级：
 * 1、MAX_PRIORITY:10
 *    MIN_PRIORITY:1
 *    NORM_PRIORITY:5  ---->默认的优先级
 * 2、如何获取和设置当前线程的优先级
 *    getPriority（）：获取线程的优先级
 *    setPriority（int p）：设置线程的优先级
 *
 *
 *
 **/
public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread3 t1=new MyThread3();
        t1.setName("线程一");
        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        //1、start()测试
        t1.start();
        //给主线程命名

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 1; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority()+":"+i);
            }
            //7、join()的测试
//            if(i==20){
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(t1.isAlive());
    }
}
class MyThread3 extends Thread{
    @Override
    //2、run()测试
    public void run() {
        for (int i = 1; i <100 ; i++) {
            if(i%2==0){
                //8、sleep()方法测试
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority()+":"+i);
            }
            //6、yield()方法测试
//            if(i%20==0){
//                this.yield();
//            }
        }
    }
}
