package JDBC.preparedStatement;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther
 * @Date 2019/11/27 12:01
 **/
public class PreparedStatementUpdateTest {
    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            FileInputStream fs = new FileInputStream("jdbc.properties");
            Properties ps = new Properties();
            ps.load(fs);
            String user=ps.getProperty("user");
            String password=ps.getProperty("password");
            String url=ps.getProperty("url");
            String driver=ps.getProperty("driver");
            //2、加载驱动
            Class.forName(driver);
            //3、获取连接
            conn = DriverManager.getConnection(url, user, password);
            //4、预编译SQL语句，返回PreparedStatement实例
            String sql="insert into book(name,author,price,type)values(?,?,?,?)";
            pps = conn.prepareStatement(sql);
            //5、填充占位
            pps.setString(1,"三国演义");
            pps.setString(2,"罗贯中");
            pps.setString(3,"30");
            pps.setString(4,"小说");
            //6、执行操作
            pps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7、关闭资源
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
}
