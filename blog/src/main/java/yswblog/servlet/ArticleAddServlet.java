package yswblog.servlet;

import yswblog.model.Article;
import yswblog.util.JSONUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 18:19
 * @Version
 **/

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {


    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ServletInputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is, Article.class);


        return null;
    }
}
