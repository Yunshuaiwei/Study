package yswblog.servlet;

import yswblog.dao.ArticleDAO;
import yswblog.exception.BusinessException;
import yswblog.model.Article;
import yswblog.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 9:09
 * @Version
 **/

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet {


    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //文章修改：包含id，title，content
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is, Article.class);
        int num= ArticleDAO.update(article);
        if(num!=1){
            throw new BusinessException("004","文章修改错误！");
        }

        return null;
    }
}
