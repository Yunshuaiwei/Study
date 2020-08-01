package ysw;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 10:52
 * @Version
 **/
public class ClassTest {
    @Test
    public void test1() throws ClassNotFoundException {
        Class<Person> clazz1 = Person.class;
        Person p = new Person();
        Class<? extends Person> clazz2 = p.getClass();
        Class<?> clazz3 = Class.forName("ysw.Person");
        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true
        System.out.println(clazz2 == clazz3);//true
    }

    //获取属性
    @Test
    public void getFieldTest() {
        Class<Person> clazz = Person.class;
        //getFields：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        //getDeclaredFieldsL：获取当前类中声明的所有属性(包括private)，不包含父类中的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        System.out.println();
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            //获取权限修饰符
            int i = f.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(i));
            //数据类型
            Class<?> type = f.getType();
            System.out.println("数据类型：" + type);
            //变量名
            String name = f.getName();
            System.out.println("变量名：" + name);
        }
    }

    //获取方法
    @Test
    public void getMethodTest() {
        Class<Person> clazz = Person.class;
        //getMethods()：获取当前类及其父类所有声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //getDeclaredMethods()：获取当前类声明的所有方法(包括私有)，不包含父类的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println();
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            //获取权限修饰符
            int i = method.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(i));
            //获取返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.println("返回值类型：" + returnType);
            //获取方法名
            String name = method.getName();
            System.out.println("方法名：" + name);
            Class<?>[] types = method.getParameterTypes();
            for (Class<?> type : types) {
                System.out.println(name + "方法的参数类型：" + type);
            }
            System.out.println();
        }

    }

    @Test
    public void getConstructorTest() {
        Class<Person> clazz = Person.class;
        //getConstructors()：获取当前类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();
        //getDeclaredConstructors()：获取当前类中的所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    //获取运行时类的父类
    @Test
    public void getSuperClassTest() {
        Class<Person> clazz = Person.class;
        //getSuperclass()：获取运行时类的父类
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);//class java.lang.Object
    }

    //获取当前类所实现的接口
    @Test
    public void getInterfaceTest() {
        Class<Person> clazz = Person.class;
        //getInterfaces()：获取当前类所实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("当前类所实现的接口：" + anInterface);//interface java.io.Serializable
        }
    }

    //获取当前类所在的包
    @Test
    public void getPackageTest() {
        Class<Person> clazz = Person.class;
        //获取当前类所在的包
        Package aPackage = clazz.getPackage();
        System.out.println("当前类所在的包：" + aPackage);//package ysw
    }

    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //获取指定属性，该属性需要声明为public
        Field age = clazz.getField("age");
        //获取指定名的属性，包括私有结构
        Field nation = clazz.getDeclaredField("nation");//该属性nation为私有属性
        //保证当前属性可访问
        nation.setAccessible(true);
        //设置指定对象的属性值
        nation.set(p, "Chain");
        String s = (String) nation.get(p);
        System.out.println(s);
        //设置当前对象的属性值
        age.set(p, 18);
        //获取当前对象的属性值
        int pAge = (int) age.get(p);
        System.out.println(pAge);//18
    }

    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //获取指定方法，参数1为方法名，参数2为该方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        //保证当前方法可访问
        show.setAccessible(true);
        //调用该方法，参数1为方法的调用者，参数2给当前方法的参数赋值
        String chain = (String) show.invoke(p, "Chain");//invoke的返回值即为对应方法的返回值
        System.out.println(chain);//null，该方法没有返回值
        //获取静态方法run()
        Method run = clazz.getDeclaredMethod("run");
        run.setAccessible(true);
        //调用该方法
        String invoke = (String) run.invoke(Person.class);
        System.out.println(invoke);
    }

}
