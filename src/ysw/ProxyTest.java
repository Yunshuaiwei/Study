package ysw;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/28 0:51
 * @Version
 **/
public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        ITeacherDao teacherDao = new TeacherDao();
        //为目标对象创建代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        System.out.println("proxyInstance" + proxyInstance.getClass());
        proxyInstance.teach();
    }
}

interface ITeacherDao {
    /**
     * @return void
     * @Param []
     * @Date 0:53 2020/7/28
     * @Description: 授课方法
     **/
    void teach();
}

class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("老师正在授课！！！");
    }
}

class ProxyFactory {

    //维护的目标对象
    private Object target;

    //初始化目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * @return java.lang.Object
     * @Param []
     * @Date 0:57 2020/7/28
     * @Description: //TODO
     * public static Object newProxyInstance(ClassLoader loader,
     *                                       Class<?>[] interfaces,
     *                                       InvocationHandler h)
     * ClassLoader loader：指定当前目标对象使用的类加载器，获取加载器的方法是固定的
     * Class<?>[] interface：目标对象实现的接口类型，使用泛型方法确认类型
     * InvocationHandler：时间处理，执行目标对象的方法时，会触发事情处理器方法，会把当前执行的目标
     * 对象方法作为参数传入
     **/
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理！！");
                        return method.invoke(target, args);
                    }
                });
    }
}