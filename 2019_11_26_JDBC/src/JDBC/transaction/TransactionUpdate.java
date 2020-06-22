package JDBC.transaction;

import JDBC.JDBCUtil.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/22 11:44
 * @Version
 **/
public class TransactionUpdate {
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            conn = JDBCUtils.getConnection();
            //关闭自动提交
            conn.setAutoCommit(false);
            String sql1 = "update account set money=money-100 where id=?";
            String sql2 = "update account set money=money+100 where id=?";
            ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, 2);
            ps1.execute();
            //模拟异常
            int i = 1 / 0;
            ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, 3);
            ps2.execute();
            //数据的提交
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    //事务回滚
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
