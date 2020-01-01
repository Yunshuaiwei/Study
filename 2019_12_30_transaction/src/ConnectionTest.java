
import JDBCUtil.JDBCUtil;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author DELL
 * @Date 2019/12/30 19:15
 **/
public class ConnectionTest {
    public static void main(String[] args) {
//        insert();
        select();
//       createTable();
    }

    public static void createTable() {
        Connection conn =null;
        PreparedStatement ps =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/stu";
            Properties p = new Properties();
            p.setProperty("user","root");
            p.setProperty("password","123456");
            conn = DriverManager.getConnection(url, p);
            String sql="create table ysw(id int,name varchar(20))";
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null){
                    ps.close();
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
    public static void insert(){
        Connection conn =null;
        PreparedStatement ps =null;
        try {
            conn = JDBCUtil.getConnection();
            String sql="insert ysw(id,name)values(1,'ysw')";
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(conn,ps);
        }
    }
    public static void select(){
        Connection conn =null;
        PreparedStatement ps =null;
        try {
            conn = JDBCUtil.getConnection();
            String sql="select * from ysw";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id="+id+"   name="+name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(conn,ps);
        }
    }
}
