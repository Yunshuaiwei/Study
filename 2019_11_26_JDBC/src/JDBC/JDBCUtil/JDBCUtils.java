package JDBC.JDBCUtil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther
 * @Date 2019/11/28 10:21
 **/
public class JDBCUtils {
    /**
     * 1、建立数据库连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //1、读取配置文件
        FileInputStream fs = new FileInputStream("jdbc.properties");
        Properties pts = new Properties();
        pts.load(fs);
        String user = pts.getProperty("user");
        String password = pts.getProperty("password");
        String url = pts.getProperty("url");
        String driver = pts.getProperty("driver");
        //加载驱动
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //关闭资源
    public static void closeResource(Connection conn, PreparedStatement pps) {
        try {
            if (pps != null) {
                pps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过druid连接池获取连接
     *
     * @return java.sql.Connection
     * @Param []
     **/
    public static Connection getDruidConnection() {
        Properties ps = new Properties();
        Connection conn = null;
        try {
            FileInputStream fs = new FileInputStream(new File("druid.properties"));
            ps.load(fs);
            DataSource ds = DruidDataSourceFactory.createDataSource(ps);
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
