package org.mapper;

import org.pojo.User;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/21 10:55
 */
public interface UserMapper {

    List<User> findAll();
}
