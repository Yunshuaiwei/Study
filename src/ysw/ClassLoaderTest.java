package ysw;

import org.junit.Test;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 8:25
 * @Version
 **/
public class ClassLoaderTest {
    @Test
    public void test() {
        //自定义类，使用系统类加载器加载
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader parent = loader.getParent();
        //调用扩展类加载器的getParen()：无法获取引导类加载器
        //引导类加载器负责加载Java核心类库，无法加载自定义类
        ClassLoader p = parent.getParent();
        System.out.println(loader);//sun.misc.Launcher$AppClassLoader@58644d46
        System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@61a52fbd
        System.out.println(p);//null
    }
}
