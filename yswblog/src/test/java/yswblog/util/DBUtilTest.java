package yswblog.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 22:09
 * @Version
 **/
public class DBUtilTest {

    @Test
    public void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
