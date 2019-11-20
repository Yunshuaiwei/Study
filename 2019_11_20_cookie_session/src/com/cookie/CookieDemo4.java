package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo4")
/**
 * Cookie快速入门
 * @author
 */
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建Cookie对象
        Cookie cookie = new Cookie("msg", "setMaxAge");
        //2、设置cookie存活时间，将cookie持久化到硬盘，30秒后自动删除cookie文件
        cookie.setMaxAge(30);
        //3、发送Cookie
        response.addCookie(cookie);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
