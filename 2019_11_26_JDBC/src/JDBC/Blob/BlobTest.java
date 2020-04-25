package JDBC.Blob;

import JDBC.JDBCUtil.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

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
        ps.setObject(1,"周杰伦");
        FileInputStream fs = new FileInputStream(new File("zjl.jpg"));
        ps.setObject(2,fs);
        ps.execute();
        JDBCUtils.closeResource(conn,ps);
    }
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        FileOutputStream fos =null;
        InputStream bs =null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="select id,name,image from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,2);
            rs = ps.executeQuery();
            if(rs.next()){
                //1、方式一
                /*int id=rs.getInt(1);
                String name = rs.getString(2);*/
                //2、方式二
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Customer cust = new Customer(id, name);
                System.out.println(cust.toString());
                //将Blob类型字段下载下来，以文件形式保存在本地
                Blob image = rs.getBlob("image");
                bs = image.getBinaryStream();
                fos = new FileOutputStream(new File("zjl2.jpg"));
                byte[] buffer = new byte[1024];
                int len;
                while((len=bs.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bs!=null){
                    bs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,ps);
        }
    }
}
