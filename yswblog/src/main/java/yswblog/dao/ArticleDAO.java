package yswblog.dao;

import com.mysql.jdbc.Connection;
import yswblog.exception.SystemException;
import yswblog.model.Article;
import yswblog.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 22:17
 * @Version
 **/
//JDBC数据库操作
public class ArticleDAO {

    /**
     * 得到文章内容列表
     *
     * @return java.util.List<yswblog.model.Article>
     * @Param []
     **/
    public static List<Article> list() {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = null;
        ResultSet r = null;
        String sql = "select id,title,content,user_id,create_time from article";
        try {
            ArrayList<Article> articles = new ArrayList<>();
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                Article article = new Article();
                article.setId(r.getInt("id"));
                article.setTitle(r.getString("title"));
                article.setContent(r.getString("content"));
                article.setUserId(r.getInt("user_id"));
                article.setCreateTime(new Date(r.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            throw new SystemException("000", "JDBC操作sql出错", e);
        } finally {
            DBUtil.close(c, p, r);
        }
    }

    /**
     * 插入数据
     *
     * @return int
     * @Param [article]
     **/
    public static int insert(Article article) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into article (user_id, title, content, create_time)" +
                " select id, ?, ?, ?" +
                " from user where name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setTimestamp(3, new Timestamp(new Date().getTime()));
            System.out.println(article.getUserAccout());
            ps.setString(4, article.getUserAccout());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("002", "新增文章出错！", e);
        } finally {
            DBUtil.close(conn, ps);
        }
    }

    public static Article query(Integer id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet r = null;
        String sql = "select id,title,content,user_id,create_time " +
                "from article where id=?";
        Article article = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            r = ps.executeQuery();
            while (r.next()) {
                article = new Article();
                article.setId(id);
                article.setTitle(r.getString("title"));
                article.setContent(r.getString("content"));
                article.setUserId(r.getInt("user_id"));
                article.setCreateTime(new Date(r.getTimestamp("create_time").getTime()));
            }
            return article;
        } catch (SQLException e) {
            throw new SystemException("003", "查询文章出错！", e);
        } finally {
            DBUtil.close(conn, ps);
        }

    }

    public static int update(Article article) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update article set title=?,content=? where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("004", "修改文章出错！", e);
        } finally {
            DBUtil.close(conn, ps);
        }
    }

    public static int delete(int[] ids) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        StringBuilder sql = new StringBuilder("delete from article where id in (");
        for (int i = 0; i < ids.length; i++) {
            if (i > 0) {
                sql.append(",");
            }
            sql.append("?");
        }
        sql.append(")");
        try {
            ps = conn.prepareStatement(sql.toString());
            for (int i = 0; i < ids.length; i++) {
                ps.setInt(i + 1, ids[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("005", "文章删除错误！", e);
        } finally {
            DBUtil.close(conn, ps);
        }
    }
}
