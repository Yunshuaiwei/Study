package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo1")
/**
 * 重定向
 * @author
 */
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo1---------");
        //访问/responseDemo1，会自动跳转到responseDemo2资源
        //1、设置状态码302
        response.setStatus(302);
        //2、设置响应头location
        response.setHeader("location","/2019_11_14_servlet/responseDemo2");
        //简单的重定向
//        response.sendRedirect("/2019_11_14_servlet/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
