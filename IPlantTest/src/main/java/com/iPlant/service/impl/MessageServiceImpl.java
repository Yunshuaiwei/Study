package com.iPlant.service.impl;

import com.iPlant.entity.MessageEntity;
import com.iPlant.mapper.MessageMapper;
import com.iPlant.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunshuaiwei
 * @className MessageServiceImpl
 * @description: TODO
 * @date 2022/4/15 15:46
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void insert(MessageEntity message) {
        messageMapper.insert(message);
    }

    @Override
    public MessageEntity getMessageAll() {
        return null;
    }

    @Override
    public MessageEntity getMessageByIp(String ip) {
        return null;
    }
}
