package com.iPlant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iPlant.entity.MessageEntity;
import com.iPlant.mapper.MessageMapper;
import com.iPlant.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<MessageEntity> getMessageAll() {
        return messageMapper.selectList(null);
    }

    @Override
    public List<MessageEntity> getMessageByIp(String ip) {
        QueryWrapper<MessageEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("ip", ip);
        return messageMapper.selectList(wrapper);
    }
}
