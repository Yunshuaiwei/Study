package com.iPlant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iPlant.entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yunshuaiwei
 * @className MessageMapper
 * @description: TODO
 * @date 2022/4/15 15:36
 */
@Mapper
@Repository
public interface MessageMapper extends BaseMapper<MessageEntity> {
}
