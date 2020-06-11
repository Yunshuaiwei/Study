import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/11 19:23
 * @Version
 **/
public class ReflectionTest {

    @Test
    public void test1(){
        Person p1 = new Person("Tom", 1);
        p1.age=10;
        System.out.println(p1.toString());
        p1.show();

    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz=Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object tom = cons.newInstance("Tom", 12);
        Person p=(Person)tom;
        System.out.println(p.toString());


    }

}
