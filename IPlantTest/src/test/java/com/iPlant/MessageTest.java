package com.iPlant;

import com.iPlant.entity.MessageEntity;
import com.iPlant.mapper.MessageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yunshuaiwei
 * @className MessageTest
 * @description: TODO
 * @date 2022/4/15 23:32
 */
@SpringBootTest
public class MessageTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void test(){
        MessageEntity entity = MessageEntity.builder().message("ceshi").build();
        messageMapper.insert(entity);
    }
}
