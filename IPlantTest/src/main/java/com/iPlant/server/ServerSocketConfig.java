package com.iPlant.server;

import com.iPlant.config.ServerReceiveThread;
import com.iPlant.mapper.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yunshuaiwei
 * @className Server
 * @description: TODO
 * @date 2022/4/15 7:56
 */
@Component
public class ServerSocketConfig {
    private static String PORT;

    @Value("${socket.port}")
    public void setPort(String port) {
        PORT = port;
    }

    private static final Logger log = LoggerFactory.getLogger(ServerSocketConfig.class);

    @Autowired
    private MessageMapper messageMapper;

    //创建线程池
    ExecutorService threadPool = Executors.newCachedThreadPool();

    public void socketCreate() {
        try {
            ServerSocket socket = new ServerSocket(Integer.parseInt(PORT));
            log.info("Socket服务已开启。。。");
            while (true) {
                Socket clientSocket = socket.accept();
                //处理客户端的请求
                threadPool.execute(new ServerReceiveThread(clientSocket,messageMapper));
            }
        } catch (IOException e) {
            log.error("Socket服务启动异常");
            e.printStackTrace();
        }
    }
}
