package ysw;

import org.junit.Test;

import java.io.*;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 10:16
 * @Version
 **/
public class ObjectInputOutputStreamTest {
    /**
     * @return void
     * @Param []
     * @Date 10:22 2020/7/31
     * @Description: 序列化
     **/
    @Test
    public void objectOutputStreamTest() throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("object.dat"));
        stream.writeObject(new String("hello"));
        stream.flush();
        stream.close();
    }

    /**
     * @return void
     * @Param []
     * @Date 10:23 2020/7/31
     * @Description: 反序列化
     **/
    @Test
    public void objectInputStreamTest() throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("object.dat"));
        String s = (String) stream.readObject();
        System.out.println(s);
        stream.close();
    }
}
