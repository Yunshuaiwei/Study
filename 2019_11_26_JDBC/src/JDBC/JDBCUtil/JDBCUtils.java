package JDBC.JDBCUtil;

import com.mysql.jdbc.Statement;

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
        Connection conn = DriverManager.getConnection(url,user, password);
        return conn;
    }
    public static void closeResource(Connection conn, PreparedStatement pps){
        try {
            if(pps!=null){
                pps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
