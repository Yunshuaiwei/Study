package ysw.servlet;

import ysw.dao.DictionaryDAO;
import ysw.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 22:53
 * @Version
 **/
@WebServlet("/dict/tag/query")
public class DictionaryTagQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags= DictionaryDAO.query(key);
        return tags;
    }
}
