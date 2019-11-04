package IOTest;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * @ProjectName 2019_10_31
 * @ClassName OtherSreamTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/4 11:27
 * @Version 1.0
 **/
public class OtherStreamTest {
    /**
     * 1、标准的输入、输出流
     * System.in：标准的输入流，默认从键盘输入
     * System.out：标准的输出流默认从控制台输出
     * 2、System类的setIn()/setOut()方式重新指定输入和输出的流
     */
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if (data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")) {
                    System.out.println("程序退出！");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
