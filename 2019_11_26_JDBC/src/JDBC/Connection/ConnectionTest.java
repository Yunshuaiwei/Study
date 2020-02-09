package JDBC.Connection;

import com.sun.media.sound.SoftTuning;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther
 * @Date 2019/11/26 15:38
 **/
public class ConnectionTest {
    /**
     * 方式一
     * @throws SQLException
     */
    @Test
    public void testConnection1() throws SQLException {
        //1、获取Driver的实现类对象
        Driver driver=new com.mysql.jdbc.Driver();
        //2、提供要连接的数据库：stu为其中的一个数据库名
        String url="jdbc:mysql://localhost:3306/stu";
        //3、封装用户名和密码
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
    /**
     * 方式二：对方式一的迭代：在如下的程序中不出现第三方的API，使程序具有更好的可移植性
     */
    @Test
    public void testConnection2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1、获取Driver实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver= (Driver) aClass.newInstance();
        //2、提供需要连接的数据库
        String url="jdbc:mysql://localhost:3306/stu";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        //4、获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
    /**
     * 方式三：迭代方式二：使用DriverManger替换Driver
     * @throws Exception
     */
    @Test
    public void testConnection3() throws Exception {
        //1、获取Driver实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver= (Driver) aClass.newInstance();
        //2、获取基本信息
        String url="jdbc:mysql://localhost:3306/stu";
        String user="root";
        String password="123456";
        //3、注册驱动
        DriverManager.registerDriver(driver);
        //4、获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
    /**
     * 方式四：只加载驱动，不用显示注册驱动
     * @throws Exception
     */
    @Test
    public void testConnection4() throws Exception {
        //1、获取基本信息
        String url="jdbc:mysql://localhost:3306/stu";
        String user="root";
        String password="123456";
        //2、加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
    /**
     * 最终版
     */
    @Test
    public void testConnection5() throws ClassNotFoundException, SQLException, IOException {
        /**
         * 1、读取配置文件中的基本信息
         */
        FileInputStream fs = new FileInputStream("jdbc.properties");
        Properties ps = new Properties();
        ps.load(fs);
        String user = ps.getProperty("user");
        String password = ps.getProperty("password");
        String url = ps.getProperty("url");
        String driver = ps.getProperty("driver");
        //2、加载驱动
        Class.forName(driver);
        //3、获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
