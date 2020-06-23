package JDBC.DBUtils;

import JDBC.DAO.AccountDAO;
import JDBC.JDBCUtil.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/23 10:19
 * @Version
 **/
public class dbUtilsTest {
    //插入测试
    @Test
    public void insertTest() {
        Connection conn = null;
        int i = 0;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getDruidConnection();
            String sql = "insert into account(name,money)values(?,?)";
            i = runner.update(conn, sql, "yunsw", "1000");
            System.out.println("成功添加了 " + i + " 条记录！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    //查询测试
    @Test
    public void testQuery() {
        QueryRunner runn = new QueryRunner();
        Connection conn = JDBCUtils.getDruidConnection();
        String sql = "select * from account where id=?";
        BeanHandler<AccountDAO> handler = new BeanHandler<>(AccountDAO.class);
        AccountDAO query = null;
        try {
            query = runn.query(conn, sql, handler, 7);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    //查询多条记录：BeanListHandler
    @Test
    public void testQueryBeanListHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getDruidConnection();
        String sql = "select id,name,money from account where money<?";
        BeanListHandler handler = new BeanListHandler(AccountDAO.class);
        try {
            List<AccountDAO> list = (List<AccountDAO>) runner.query(conn, sql, handler, 10000);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    //查询特殊值
    @Test
    public void countTestScalarHandler() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getDruidConnection();
            String sql = "select Max(money) from account";
            ScalarHandler handler = new ScalarHandler();
            Double query = (Double) runner.query(conn, sql, handler);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}
