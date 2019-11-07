/**
 * @ProjectName Study
 * @ClassName ThreadRunnable
 * Description
 * @Auther YunSW
 * @Date 2019/11/7 18:24
 * @Version 1.0
 **/
public class ThreadRunnable {
    public static void main(String[] args) {
        //3、创建实现类的对象
        MThread mThread = new MThread();
        //4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        //5、通过Thread类的对象调用start（）
        t1.setName("线程一");
        t1.start();
        //再启动一个线程
        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();
    }
}
//1、实现Runnable接口
class MThread implements Runnable{
    //2、实现Runnable中的抽象方法：run（）
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}