package ysw;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/16 8:01
 * @Version
 **/
public class Demo {
    public static void main(String[] args) {
        Properties p = new Properties();
        FileInputStream inputStream = null;
        try {
            //获取输入流
            inputStream = new FileInputStream("./src/jdbc.properties");
            p.load(inputStream);
            //通过key得到值
            String user = p.getProperty("user");
            String driver = p.getProperty("driver");
            System.out.println(user + "\n" + driver);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(5);
        list.add(0);
        list.add(6);
        list.add(50);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> list1 = Collections.synchronizedList(list);
        System.out.println(list);
    }

    @Test
    public void stringTest() {
        String s = new String("abc");
        String str = "abc";
        char[] chars = str.toCharArray();
        String str2 = new String(chars);
        for (char c : chars) {
            System.out.println(c);
        }
    }

    @Test
    public void byteTest() {
        Person p = new Person();
        p.name = "abc";

    }
}

class Person implements Serializable {
    public String name;
    public int age;
    private String nation;

    public Person() {
    }

    public Person(String name, int age, String nation) {
        this.age = age;
        this.name = name;
        this.nation = nation;
    }

    private Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void show(String nation) {
        System.out.println("nation=" + nation);
    }

    private String eat() {
        System.out.println("eat");
        return "ok";
    }

    public static String run() {
        System.out.println("run");
        return "OK";
    }
}
