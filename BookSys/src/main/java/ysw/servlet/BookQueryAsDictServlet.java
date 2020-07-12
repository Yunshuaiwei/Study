package ysw.servlet;

import ysw.dao.BookDAO;
import ysw.model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 23:31
 * @Version
 **/
@WebServlet("/book/queryAsDict")
public class BookQueryAsDictServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Book> books= BookDAO.queryAsDict();
        return books;
    }
}
