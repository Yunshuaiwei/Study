package org.example;

import org.dao.impl.UserDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
        System.out.println(userDao);
    }
}