package ysw.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import ysw.exception.SystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 19:59
 * @Version
 **/
public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/book";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static volatile DataSource DATA_SOURCE;

    private DBUtil() {
    }

    private static DataSource dataSource() {
        if (DATA_SOURCE == null) {
            synchronized (DBUtil.class) {
                if (DATA_SOURCE == null) {
                    DATA_SOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATA_SOURCE).setPassword(PASSWORD);
                    ((MysqlDataSource) DATA_SOURCE).setUser(USERNAME);
                    ((MysqlDataSource) DATA_SOURCE).setURL(URL);

                }
            }
        }
        return DATA_SOURCE;
    }

    /**
     * @return java.sql.Connection
     * @Param []
     * @Date 20:12 2020/7/12
     * @Description: 获取连接
     **/
    public static Connection getConnection() {
        try {
            return dataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException("0001", "获取数据库连接失败！", e);
        }
    }

    public static void close(Connection conn, Statement s) {
        close(conn, s, null);
    }

    /**
     * @return void
     * @Param [conn, s, r]
     * @Date 20:31 2020/7/12
     * @Description: 释放资源
     **/
    public static void close(Connection conn, Statement s, ResultSet r) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (s != null) {
                s.close();
            }
            if (r != null) {
                r.close();
            }
        } catch (SQLException e) {
            throw new SystemException("0002", "释放数据库资源失败！", e);
        }
    }
}
