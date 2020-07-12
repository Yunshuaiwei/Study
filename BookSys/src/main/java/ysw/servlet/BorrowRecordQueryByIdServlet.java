package ysw.servlet;

import ysw.dao.BorrowRecordDAO;
import ysw.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 23:56
 * @Version
 **/
@WebServlet("/borrowRecord/queryById")
public class BorrowRecordQueryByIdServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id=Integer.parseInt(req.getParameter("id"));
        BorrowRecord record= BorrowRecordDAO.queryById(id);
        return record;
    }
}
