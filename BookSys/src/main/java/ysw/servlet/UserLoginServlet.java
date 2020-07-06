package ysw.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/6 17:26
 * @Version
 **/
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
        HashMap json = new ObjectMapper().readValue(req.getInputStream(), HashMap.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success",true);
        map.put("code",200);
        System.out.println(json);
        PrintWriter writer = resp.getWriter();
        writer.print(new ObjectMapper().writeValueAsString(map));
        writer.flush();
    }
}
