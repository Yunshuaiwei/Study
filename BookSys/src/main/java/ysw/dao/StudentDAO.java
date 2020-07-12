package ysw.dao;

import ysw.exception.SystemException;
import ysw.model.Student;
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
 * @Date 2020/7/12 23:46
 * @Version
 **/
public class StudentDAO {
    public static List<Student> queryAsDict(int id) {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select id, student_name, student_no, id_card from student where classes_id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setDictionaryTagKey(rs.getString("id"));
                student.setDictionaryTagValue(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setIdCard(rs.getString("id_card"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new SystemException("0005", "查询字典信息出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return students;
    }
}
