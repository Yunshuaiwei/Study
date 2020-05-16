package yswblog.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 9:16
 * @Version
 **/

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String ids = req.getParameter("ids");
        int[] ints = parseIds(ids);
        //将ints传入数据库进行删除
        return null;
    }

    public static int[] parseIds(String idsString) {
        String[] idsArray = idsString.split(",");
        int[] ids = new int[idsArray.length];
        for (int i = 0; i < idsArray.length; i++) {
            ids[i] = Integer.parseInt(idsArray[i]);
        }
        return ids;
    }

}
