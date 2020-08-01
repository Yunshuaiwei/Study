package ysw;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/28 12:39
 * @Version
 **/
public class DateTest {

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test1() {
        Date date = new Date();
        System.out.println(date);//Tue Jul 28 12:43:12 CST 2020
        System.out.println(date.getTime());//1595911392711
    }

    @Test
    public void test2() {
        Date date = new Date(1595911392711L);
        System.out.println(date);//Tue Jul 28 12:43:12 CST 2020
    }

    @Test
    public void test3() {
        java.sql.Date date = new java.sql.Date(1595911392711L);
        int a = 10;
        int b = 0;
        try {
            int c = a / b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("最后会被执行的代码！！");
        }
    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //使用默认的格式化方式
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date d = new Date();
        String s = dateFormat.format(d);
        System.out.println(s);//20-7-30 上午11:15
        //使用指定的格式化方式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s1 = format.format(d);
        System.out.println(s1);//2020-07-30 11:18:11
        //将字符串解析为日期
        Date parse = format.parse("2020-07-30 11:10:10");
        System.out.println(parse);//Thu Jul 30 11:10:10 CST 2020
    }
}
