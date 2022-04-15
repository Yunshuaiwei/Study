package com.iPlant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author yunshuaiwei
 * @className ClientTest
 * @description: TODO
 * @date 2022/4/15 13:20
 */
@SpringBootTest
public class ClientTest {
    //用于接收数据
    private byte[] bytes = new byte[1024];

    @Test
    public void test() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            String str = "hello";
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            //接收服务端的数据
            StringBuilder request = null;
            int len = inputStream.read(bytes);
            request = new StringBuilder();
            System.out.println(len);
            request.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            System.out.println("接收到服务端响应: " + request.toString());

            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
