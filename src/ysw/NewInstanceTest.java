package ysw;

import org.junit.Test;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 8:38
 * @Version
 **/
public class NewInstanceTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        //创建对象的运行时类的对象，内部调用类的空参构造器
        Person p = clazz.newInstance();
    }
}
