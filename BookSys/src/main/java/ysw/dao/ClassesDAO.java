package ysw.dao;

import ysw.exception.SystemException;
import ysw.model.Classes;
import ysw.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 23:21
 * @Version
 **/
public class ClassesDAO {
    public static List<Classes> queryAsDict() {
        List<Classes> classesList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select id, classes_name, classes_graduate_year, classes_major from classes";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                classes.setDictionaryTagValue(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classesList.add(classes);
            }
        } catch (SQLException e) {
            throw new SystemException("0004", "查询班级数据字典信息出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return classesList;
    }
}
