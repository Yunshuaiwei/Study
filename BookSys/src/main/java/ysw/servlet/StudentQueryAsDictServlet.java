package ysw.servlet;

import ysw.dao.StudentDAO;
import ysw.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 23:43
 * @Version
 **/
@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        int id=Integer.parseInt(req.getParameter("dictionaryKey"));
        List<Student> students= StudentDAO.queryAsDict(id);

        return students;
    }
}
