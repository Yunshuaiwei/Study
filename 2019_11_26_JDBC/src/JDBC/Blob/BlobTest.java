package JDBC.Blob;

import JDBC.JDBCUtil.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 测试使用PreparedStatement操作Blob类型的数据
 */
public class BlobTest {
    /**
     * 向数据表customer中插入Blob类型的字段
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="insert into customers(name,image)values(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"房东的猫");
        FileInputStream fs = new FileInputStream(new File("房东的猫1.jpg"));
        ps.setObject(2,fs);
        ps.execute();
        JDBCUtils.closeResource(conn,ps);
    }
}
