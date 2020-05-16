package yswblog.util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import yswblog.exception.SystemException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 20:28
 * @Version
 **/
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/blog";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static volatile DataSource DS;

    private static DataSource getDataSource() {
        if (DS == null) {
            synchronized (DBUtil.class) {
                if (DS == null) {
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setURL(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    /**
     * 获取数据库连接
     *
     * @return com.mysql.jdbc.Connection
     * @Param []
     **/
    public static Connection getConnection() {
        try {
            return (Connection) getDataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException("000", "获取数据库连接失败！", e);
        }
    }

    public static void close(Connection c, Statement s) {
        close(c, s, null);
    }

    /**
     * 关闭资源
     *
     * @return void
     * @Param [c, s, r]
     **/
    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if (c != null) {
                c.close();
            }
            if (s != null) {
                s.close();
            }
            if (r != null) {
                r.close();
            }
        } catch (SQLException e) {
            throw new SystemException("000", "数据库释放资源失败", e);
        }
    }
}
