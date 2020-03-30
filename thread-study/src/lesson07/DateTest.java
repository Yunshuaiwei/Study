package lesson07;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DELL
 * @Date 2020/3/30 17:12
 **/
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
    }
}
