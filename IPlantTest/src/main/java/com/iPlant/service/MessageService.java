package com.iPlant.service;

import com.iPlant.entity.MessageEntity;

import java.util.List;

public interface MessageService {

    void insert(MessageEntity message);

    List<MessageEntity> getMessageAll();

    List<MessageEntity> getMessageByIp(String ip);
}
