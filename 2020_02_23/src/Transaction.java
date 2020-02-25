import JDBCUtil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author DELL
 * @Date 2020/2/23 14:59
 **/
public class Transaction {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //关闭自动提交数据
            conn.setAutoCommit(false);
            String sql = "update bill set balance=balance-100 where name=？";
            update(conn, sql, "Jack");
            String sql2 = "update bill set balance=balance+100 where name= ?";
            update(conn, sql2, "Tom");
            System.out.println("转账成功！");
            //提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    //回滚
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public static int update(Connection conn, String sql, Object... args) {
        PreparedStatement pps = null;
        try {
            pps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pps.setObject(i + 1, args[i]);
            }
            return pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, pps);
        }
        return 0;
    }
}
