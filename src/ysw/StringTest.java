package ysw;

import org.junit.Test;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/28 9:07
 * @Version
 **/
public class StringTest {
    @Test
    public void testString(){
        String s1="JavaEE";
        String s2="JavaEE";

        String s3=new String("JavaEE");
        String s4=new String("JavaEE");
        System.out.println(s1==s2) ;//true
        System.out.println(s3==s4);//false
        System.out.println(s1==s3);//false
    }
    @Test
    public void testString2(){
        String s1="JavaEE";
        String s2="Hadoop";

        String s3="JavaEEHadoop";
        String s4="JavaEE"+"Hadoop";
        String s5=s1+"Hadoop";
        String s6="JavaEE"+s2;
        String s7=s1+s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8=s5.intern();//返回值为常量池中字符串的地址
        System.out.println(s3 == s8);//true
    }
}
