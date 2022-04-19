package com.iPlant.thread;

import com.iPlant.entity.MessageEntity;
import com.iPlant.mapper.MessageMapper;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;

/**
 * @author yunshuaiwei
 * @className ServerReceiveThred
 * @description: TODO
 * @date 2022/4/15 11:04
 */
@Component
@NoArgsConstructor
public class ServerReceiveThread implements Runnable {
    private static Socket socket;

    private static final Logger log = LoggerFactory.getLogger(ServerReceiveThread.class);

    private MessageMapper messageMapper;

    public ServerReceiveThread(Socket socket,MessageMapper messageMapper) {
        ServerReceiveThread.socket = socket;
        this.messageMapper=messageMapper;
    }

    @SneakyThrows
    @Override
    public void run() {
        //输入流接收数据
        InputStream inputStream = null;
        //输出流发送数据
        OutputStream outputStream = null;
        //响应数据
        String response="";
        //用于接收数据
        byte[] bytes = new byte[2048];
        try {
            //输入流接收数据
            inputStream = socket.getInputStream();
            //输出流发送数据
            outputStream = socket.getOutputStream();
            //处理数据
            StringBuilder request = new StringBuilder();
            log.info("线程信息：{}", Thread.currentThread().getName());
            while (true){
                int len = inputStream.read(bytes);
                if (len != -1) {
                    request.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                    if ("exit".equals(request.toString()) || "close".equals(request.toString())) {
                        response=request.toString();
                        break;
                    } else {
                        response = "接收数据成功！";
                    }
                    outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                    log.info("接收到的数据为：{}", request);
                    log.info("响应数据为：{}", response);

                    MessageEntity message = MessageEntity.builder().message(Objects.requireNonNull(request).toString())
                            .ip(socket.getInetAddress().getHostAddress())
                            .response(response)
                            .threadName(Thread.currentThread().getName())
                            .port(String.valueOf(socket.getPort()))
                            .createTime(new Date())
                            .build();
                    log.info("存入数据库：{}", message.toString());
                    //插入数据库
                    messageMapper.insert(message);
                    request=new StringBuilder();
                }else{
                    break;
                }
            }
            MessageEntity message = MessageEntity.builder().message(Objects.requireNonNull(request).toString())
                    .ip(socket.getInetAddress().getHostAddress())
                    .response(response)
                    .threadName(Thread.currentThread().getName())
                    .port(String.valueOf(socket.getPort()))
                    .createTime(new Date())
                    .build();
            log.info("存入数据库：{}", message.toString());
            //插入数据库
            messageMapper.insert(message);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("数据处理异常:" + e.getMessage());
        } finally {
            log.warn("关闭连接！");
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            socket.close();
        }
    }
}
