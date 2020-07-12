package ysw.servlet;

import ysw.dao.BorrowRecordDAO;
import ysw.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 21:36
 * @Version
 **/
@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<BorrowRecord> records= BorrowRecordDAO.queryAll();
        return records;
    }
}
