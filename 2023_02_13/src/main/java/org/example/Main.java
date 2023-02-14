package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yunshuaiwei
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //静态工厂
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //构造函数实例化
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //实例工厂
        SqlSessionFactory factory = builder.build(inputStream);
        System.out.println(factory);

    }
}