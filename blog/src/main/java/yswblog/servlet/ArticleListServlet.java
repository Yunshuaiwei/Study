package yswblog.servlet;

import yswblog.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 17:27
 * @Version
 **/

@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return testData();
    }

    public static List<Article> testData() {
        ArrayList<Article> list = new ArrayList<>();
        Article art1 = new Article();
        Article art2 = new Article();
        art1.setId(1);
        art1.setTitle("Java编程思想");
        art1.setContent("面向对象！");
        art1.setUserId(1);
        art1.setCreateTime(new Date());
        art2.setId(2);
        art2.setTitle("Java核心卷I");
        art2.setContent("面向对象！");
        art2.setUserId(1);
        art2.setCreateTime(new Date());
        list.add(art1);
        list.add(art2);

        return list;
    }
}
