package com.iPlant.service;

import com.iPlant.entity.MessageEntity;

public interface MessageService {

    void insert(MessageEntity message);

    MessageEntity getMessageAll();

    MessageEntity getMessageByIp(String ip);
}
