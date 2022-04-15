package com.iPlant.controller;

import com.iPlant.entity.MessageEntity;
import com.iPlant.entity.ResponseEntity;
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
    public ResponseEntity getMessageAll() {
        List<MessageEntity> messageAll = messageService.getMessageAll();
        return ResponseEntity.builder().code("200")
                .msg("success")
                .data(messageAll)
                .build();
    }

    @RequestMapping(value = "/message/{ip}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getMessageByIp(@PathVariable("ip") String ip) {
        List<MessageEntity> messageByIp = messageService.getMessageByIp(ip);
        return ResponseEntity.builder().code("200")
                .msg("success")
                .data(messageByIp)
                .build();
    }
}
