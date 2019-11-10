package java3;

import com.sun.media.sound.SoftTuning;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @ProjectName Study
 * @ClassName NumThread
 * Description
 * @Auther YunSW
 * @Date 2019/11/10 17:52
 * @Version 1.0
 **/
public class NumThread {
    public static void main(String[] args) {
        //3、创建Callable接口实现类的对象
        ThreadNew threadNew = new ThreadNew();
        //4、将次Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTaste的对象
        FutureTask task = new FutureTask(threadNew);
        //5、将FutureTaste的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start方法
        new Thread(task).start();
        try {
            //6、获取Callable中call的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值
            Object o = task.get();
            System.out.println("总和为"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
//1、创建一个实现Callable的实现类
class ThreadNew implements Callable{
    //2、实现call方法，将此线程需要的操作声明在call中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}