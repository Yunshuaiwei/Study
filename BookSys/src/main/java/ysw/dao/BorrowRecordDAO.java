package ysw.dao;

import ysw.exception.SystemException;
import ysw.model.Book;
import ysw.model.BorrowRecord;
import ysw.model.Classes;
import ysw.model.Student;
import ysw.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 22:05
 * @Version
 **/
public class BorrowRecordDAO {
    public static List<BorrowRecord> queryAll() {
        List<BorrowRecord> records = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       book_name," +
                    "       author," +
                    "       price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    " from borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BorrowRecord br = new BorrowRecord();
                br.setId(rs.getInt("id"));
                br.setStartTime(new Date(rs.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(rs.getTimestamp("end_time").getTime()));
                br.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                br.setBook(book);
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentNo(rs.getString("student_no"));
                s.setIdCard(rs.getString("id_card"));
                s.setStudentEmail(rs.getString("student_email"));
                br.setStudent(s);
                Classes classes = new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classes.setClassesDesc(rs.getString("classes_desc"));
                br.setClasses(classes);
                records.add(br);
            }
        } catch (SQLException e) {
            throw new SystemException("0001", "查询图书借阅信息出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return records;
    }

    public static BorrowRecord queryById(int id) {
        BorrowRecord br = new BorrowRecord();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       book_name," +
                    "       author," +
                    "       price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    " from borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id" +
                    " where br.id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                br.setId(rs.getInt("id"));
                br.setStartTime(new Date(rs.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(rs.getTimestamp("end_time").getTime()));
                br.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                br.setBook(book);
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentNo(rs.getString("student_no"));
                s.setIdCard(rs.getString("id_card"));
                s.setStudentEmail(rs.getString("student_email"));
                br.setStudent(s);
                Classes classes = new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classes.setClassesDesc(rs.getString("classes_desc"));
                br.setClasses(classes);
            }
        } catch (SQLException e) {
            throw new SystemException("0006", "查询图书借阅信息详情出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return br;
    }
}
