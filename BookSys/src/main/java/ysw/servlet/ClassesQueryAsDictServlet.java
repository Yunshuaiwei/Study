package ysw.servlet;

import ysw.dao.ClassesDAO;
import ysw.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 23:19
 * @Version
 **/
@WebServlet("/classes/queryAsDict")
public class ClassesQueryAsDictServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Classes> classesList= ClassesDAO.queryAsDict();
        return classesList;
    }
}
