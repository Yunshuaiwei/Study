package org.service.impl;

import org.mapper.UserMapper;
import org.pojo.User;
import org.service.UserService;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/13 6:41
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void show() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
