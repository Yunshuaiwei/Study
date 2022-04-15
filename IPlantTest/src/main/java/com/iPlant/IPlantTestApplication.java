package com.iPlant;

import com.iPlant.server.ServerSocketConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yunshuaiwei
 * @className IPlantTestApplication
 * @description: TODO
 * @date 2022/4/15 8:40
 */
@SpringBootApplication
@MapperScan(value = "com.iPlant.mapper")
public class IPlantTestApplication {

    private static ServerSocketConfig serverSocketConfig;

    @Autowired
    public void setServerSocketConfig(ServerSocketConfig serverSocketConfig){
        IPlantTestApplication.serverSocketConfig=serverSocketConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(IPlantTestApplication.class,args);
        serverSocketConfig.socketCreate();
    }
}
