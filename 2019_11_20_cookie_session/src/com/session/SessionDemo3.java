package com.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取Session对象
        HttpSession s = request.getSession();
        //期望客户端关闭后Session可以相同
        Cookie c=new Cookie("JSESSIONID",s.getId());
        c.setMaxAge(60*60);
        System.out.println(s.getId());
        response.addCookie(c);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
