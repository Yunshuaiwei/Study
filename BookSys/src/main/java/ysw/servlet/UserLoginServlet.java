package ysw.servlet;

import ysw.dao.UserDAO;
import ysw.exception.BusinessException;
import ysw.model.User;
import ysw.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/6 17:26
 * @Version
 **/
@WebServlet("/user/login")
public class UserLoginServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user= JSONUtil.read(req.getInputStream(),User.class);
        User queryUser= UserDAO.querry(user);
        if (queryUser==null){
            throw new BusinessException("0001","用户名密码校验失败！");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",queryUser);
        return null;
    }
}

