import proxy.ProxyTest;
import proxy.ProxyTestImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yunshuaiwei
 * @className TestDemo
 * @description: 动态代理测试
 * @date 2022/3/9 10:34
 */
public class ProxyTestDemo {
    public static void main(String[] args) {
        //基于接口的动态代理
        ProxyTestImpl proxyTest = new ProxyTestImpl();
        ProxyTest proxyClass = (ProxyTest) Proxy.newProxyInstance(proxyTest.getClass().getClassLoader(), proxyTest.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * @author yunshuaiwei
             * @description TODO
             * @date 10:42 2022/3/9
             * @Param [proxy: 代理对象的引用]
             * @Param [method：当前执行的方法]
             * @Param [args：当前执行方法所需的参数]
             * @Return java.lang.Object 和被代理对象有相同的返回值
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取方法的参数
                int money= (int) args[0];
                if ("buyGoods".equals(method.getName())){
                    return method.invoke(proxyTest,(int)(money*0.8));
                }
                return null;
            }
        });
        proxyClass.buyGoods(10000);
    }
}
