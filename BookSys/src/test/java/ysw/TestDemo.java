package ysw;

import org.junit.Test;
import ysw.model.ResponseResult;
import ysw.util.DBUtil;
import ysw.util.JSONUtil;

import java.io.InputStream;
import java.sql.Connection;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 20:43
 * @Version
 **/
public class TestDemo {
    @Test
    public void testConnection(){
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
    }
    @Test
    public void testJsonRead(){
        InputStream res = getClass().getClassLoader().getResourceAsStream("response.json");
        ResponseResult r = JSONUtil.read(res, ResponseResult.class);
        System.out.println(r);

    }
    @Test
    public void testJsonWrite(){
        ResponseResult res = new ResponseResult();
        res.setCode("200");
        res.setMessage("ok");
        res.setSuccess(true);
        res.setTotal(1);
        res.setStackTrace("stack");
        String w = JSONUtil.write(res);
        System.out.println(w);
    }

}
