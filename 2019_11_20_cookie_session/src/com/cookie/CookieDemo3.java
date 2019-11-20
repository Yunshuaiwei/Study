package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo3")
/**
 * Cookie快速入门
 * @author
 */
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建Cookie对象
        Cookie cookie1 = new Cookie("msg", "hello");
        Cookie cookie2 = new Cookie("name", "ysw");
        //2、发送Cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
