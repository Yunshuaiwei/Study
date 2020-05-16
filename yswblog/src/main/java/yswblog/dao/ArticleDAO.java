package yswblog.dao;

import com.mysql.jdbc.Connection;
import yswblog.exception.SystemException;
import yswblog.model.Article;
import yswblog.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
