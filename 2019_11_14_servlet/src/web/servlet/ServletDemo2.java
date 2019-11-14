package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName Study
 * @ClassName ServletDemo2
 * Description
 * @Auther YunSW
 * @Date 2019/11/14 11:41
 * @Version 1.0
 **/
//    @WebServlet({"/demo4","/demo2","/demo3"})
//    @WebServlet("/user/demo1")
//    @WebServlet("/user/*")
//    @WebServlet("/*")
//    @WebServlet("/*.do")
    @WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("............");
    }
}
