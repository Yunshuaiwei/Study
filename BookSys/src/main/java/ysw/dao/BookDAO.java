package ysw.dao;

import ysw.exception.SystemException;
import ysw.model.Book;
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
 * @Date 2020/7/12 23:32
 * @Version
 **/
public class BookDAO {
    public static List<Book> queryAsDict() {
        List<Book> books = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select id,book_name,author,price from book";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                book.setDictionaryTagValue(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new SystemException("0005", "查询图书数据字典信息出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return books;
    }
}
