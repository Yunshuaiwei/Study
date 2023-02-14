package org.utils;

import org.dao.impl.UserDaoImpl;

/**
 * 自定义的bean工厂
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/13 11:42
 */
public class BeanFactory {

    /**
     * 静态工厂方式
     * @author yunshuaiwei
     * @date 2023/2/13 11:47
     **/
    public static UserDaoImpl userDao(){
        //bean创建之前可以进行别的一些操作
        return new UserDaoImpl();
    }
}
