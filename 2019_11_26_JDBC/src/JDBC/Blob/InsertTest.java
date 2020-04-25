package JDBC.Blob;

import JDBC.JDBCUtil.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Auther
 * @Date 2019/11/29 11:11
 **/
public class InsertTest {
    @Test
    public void test(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //方式三：设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql="insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            final int value=1000000;
            long start = System.currentTimeMillis();
            for (int i = 0; i <value ; i++) {
                ps.setObject(1,"name_"+i);
                //方式一
//                ps.execute();
                //方式二
                //1、“攒”SQL
                ps.addBatch();
                if(i%500==0){
                    //2、执行batch
                    ps.executeBatch();
                    //3、清空batch
                    ps.clearBatch();
                }
            }
            //统一提交数据
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("执行时间为："+(end-start));
            //方式一执行时间为：29135
            //方式二执行时间为：279    1000000--->执行时间为：9568
            //方式三：1000000--->执行时间为：5000
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
}
