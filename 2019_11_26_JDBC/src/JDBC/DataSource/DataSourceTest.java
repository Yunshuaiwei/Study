package JDBC.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/22 21:21
 * @Version
 **/
public class DataSourceTest {
    @Test
    public void testGetConnection() throws Exception {
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/ysw");
        cpds.setUser("root");
        cpds.setPassword("123456");

        //初始数据库连接数
        cpds.setInitialPoolSize(10);
        //获取连接
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

    //使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hello");
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }
}
