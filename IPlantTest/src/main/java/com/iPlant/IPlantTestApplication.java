package com.iPlant;

import com.iPlant.server.ServerSocketConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yunshuaiwei
 * @className IPlantTestApplication
 * @description: TODO
 * @date 2022/4/15 8:40
 */
@SpringBootApplication
public class IPlantTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(IPlantTestApplication.class,args);
        ServerSocketConfig socket = new ServerSocketConfig();
        socket.socketCreate();
    }
}
