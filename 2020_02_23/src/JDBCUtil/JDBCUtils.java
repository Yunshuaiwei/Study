package JDBCUtil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author DELL
 * @Date 2020/2/23 14:42
 **/
public class JDBCUtils {
    public static Connection getConnection() throws Exception {
        //1、读取配置文件
        FileInputStream fs = new FileInputStream("E:\\JavaCodeIDEA\\Study\\2020_02_23\\jdbc.properties");
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
}
