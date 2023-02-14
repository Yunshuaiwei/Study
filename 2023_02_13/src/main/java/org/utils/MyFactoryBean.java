package org.utils;

import org.service.UserService;
import org.service.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * Bean工厂实例化bean
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/13 12:05
 */
public class MyFactoryBean implements FactoryBean<UserService> {
    @Override
    public UserService getObject() throws Exception {
        return new UserServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }
}
