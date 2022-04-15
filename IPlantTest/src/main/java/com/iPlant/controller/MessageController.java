package com.iPlant.controller;

import com.iPlant.entity.MessageEntity;
import com.iPlant.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yunshuaiwei
 * @className MessageController
 * @description: TODO
 * @date 2022/4/15 15:31
 */
@Controller
@RequestMapping("iplant")
public class MessageController {
    @Autowired
    private MessageService messageService;


    @GetMapping(value = "/message")
    @ResponseBody
    public MessageEntity getMessageAll(){
        List<MessageEntity> messageAll = messageService.getMessageAll();
        return null;
    }

    @RequestMapping(value = "/message/{ip}",method = RequestMethod.GET)
    @ResponseBody
    public MessageEntity getMessageByIp(@PathVariable("ip") String ip){
        List<MessageEntity> messageByIp = messageService.getMessageByIp(ip);
        return null;
    }

}
