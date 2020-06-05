package jvm;

import org.junit.Test;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/20 16:18
 * @Version
 **/
public class StringTest {
    /**
     * 对象1:new StringBuilder()
     * 对象2:new String("a")
     * 对象3:常量池中的对象"a"
     * 对象4:new String("b")
     * 对象5:常量池中的对象"b"
     * <p>
     * StringBuilder的toString方法
     * 对象6:new String("ab")
     *
     * @return void
     * @Param [args]
     **/
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();//调用此方法，字符串常量池中已经存在"1"
        String s2 = "1";
        System.out.println(s == s2);//jdk6:false  jdk7/8:false

        String s3 = new String("1") + new String("1");//s3的地址为new String("11")
        //执行完上述代码，字符串常量池中并不存在"11"
        s3.intern();//字符串常量池中生成"11"。jdk6:创建了一个新的对象，即会有一个新的地址
        //                                 jdk7/8:此时常量池中并没有创建"11"，而是创建了一个执行堆空间new String("11")的地址

        String s4 = "11";//s4变量记录的地址:使用的是上一次代码执行时，在常量池中生成的"11"的地址
        System.out.println(s3 == s4);//jdk6:false jdk7/8:true
    }

    @Test
    public void test() {
        String s1 = "JavaEE";
        String s2 = "Hadoop";

        String s3 = "JavaEEHadoop";
        String s4 = "JavaEE" + "Hadoop";//编译期优化
        //如果拼接符前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果:JavaEEHadoop
        String s5 = s1 + "Hadoop";
        String s6 = "JavaEE" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s6 == s7);//false
        //intern():判断字符串常量池中是否存在JavaHadoop值，如果存在，则返回常量池中JavaHadoop的地址，
        //如果字符串常量池中不存在JavaHadoop，则在常量池中加载一份JavaHadoop，并返回此对象的地址
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true
    }

    @Test
    public void test1() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        //s1+s2执行细节
        //① StringBuilder s=new StringBuilder();
        //② s.append("a");
        //③ s.append("b");
        //④ s.toString() --> 约等于new String("ab")
        System.out.println(s3 == s4);//false
    }

    @Test
    public void test2() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        //s1和s2使用final修饰，即拼接符号两边都是字符串常量，则仍然使用编译器优化
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
    }
}