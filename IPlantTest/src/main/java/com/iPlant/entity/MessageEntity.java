package com.iPlant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yunshuaiwei
 * @className Message
 * @description: TODO
 * @date 2022/4/15 11:21
 */
@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@TableName("message")
public class MessageEntity {

    @TableId(type=IdType.AUTO)
    public Long id;

    @TableField(value = "ip")
    public String ip;

    @TableField(value = "port")
    public String port;

    @TableField(value = "message")
    public String message;

    @TableField(value = "response")
    public String response;

    @TableField(value = "threadName")
    public String threadName;

    @TableField(value = "createTime")
    public Date createTime;
}
