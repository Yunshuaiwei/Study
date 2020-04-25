import JDBCUtil.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author DELL
 * @Date 2019/12/30 14:47
 **/
public class TransactionTest {
    @Test
    public void test(){
        Connection conn =null;
        try {
            conn = JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}
