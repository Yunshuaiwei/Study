import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/11 19:23
 * @Version
 **/
public class ReflectionTest {
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 1);
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        Constructor con = clazz.getConstructor(String.class, int.class);
        Object tom = con.newInstance("Tom", 10);
//        System.out.println(tom.toString());
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom, "Marry");
//        System.out.println(tom.toString());
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(tom, "Chain");
        System.out.println(nation);
    }
}
