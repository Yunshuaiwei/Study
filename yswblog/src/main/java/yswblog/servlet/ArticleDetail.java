package yswblog.servlet;

import yswblog.exception.ClientException;
import yswblog.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 18:48
 * @Version
 **/
@WebServlet("/articleDetail")
public class ArticleDetail extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        try {
            Integer articleId = Integer.parseInt(id);
        } catch (Exception e) {
            throw new ClientException("001", "请求参数错误：id=" + id);
        }
        return testData();//之后替换为数据库查询出的数据
    }

    public static Article testData() {
        Article art1 = new Article();
        art1.setId(1);
        art1.setTitle("Java编程思想");
        art1.setContent("面向对象！");
        art1.setUserId(1);
        art1.setCreateTime(new Date());
        return art1;
    }

}
