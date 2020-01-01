package JDBCUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author DELL
 * @Date 2019/12/30 14:50
 **/
public class JDBCUtil {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        FileInputStream fs = new FileInputStream("2019_12_30_transaction/jdbc.properties");
        Properties pts = new Properties();
        pts.load(fs);
        String user = pts.getProperty("user");
        String password = pts.getProperty("password");
        String url = pts.getProperty("url");
        String driver = pts.getProperty("driver");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    public static void closeResource(Connection conn , PreparedStatement ps){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
