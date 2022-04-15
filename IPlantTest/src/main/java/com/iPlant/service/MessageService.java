package com.iPlant.service;

import com.iPlant.entity.MessageEntity;

import java.util.List;

public interface MessageService {

    /**
     * @author yunshuaiwei
     * @description 插入数据
     * @date 0:07 2022/4/16
     */
    void insert(MessageEntity message);

    /**
     * @author yunshuaiwei
     * @description 查询所有数据
     * @date 0:06 2022/4/16
     */
    List<MessageEntity> getMessageAll();

    /**
     * @author yunshuaiwei
     * @description 根据IP查询数据
     * @date 0:06 2022/4/16
     */
    List<MessageEntity> getMessageByIp(String ip);
}
