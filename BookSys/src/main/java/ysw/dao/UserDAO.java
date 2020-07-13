package ysw.dao;

import ysw.exception.SystemException;
import ysw.model.User;
import ysw.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/13 9:43
 * @Version
 **/
public class UserDAO {
    public static User querry(User user) {
        User queryUser=null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select id,username,password,nickname from user where username=?and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                queryUser=user;
                queryUser.setId(rs.getInt("id"));
                queryUser.setNickname(rs.getString("nickname"));
            }
        } catch (SQLException e) {
            throw new SystemException("0007", "用户名密码错误", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return queryUser;
    }
}
