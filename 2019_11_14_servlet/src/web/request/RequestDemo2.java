package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ProjectName Study
 * @ClassName RequestDemo2
 * Description
 * @Auther YunSW
 * @Date 2019/11/15 11:09
 * @Version 1.0
 **/
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求头名称
        Enumeration<String> headerNames=req.getHeaderNames();
        //2、遍历
        while(headerNames.hasMoreElements()){
            String name=headerNames.nextElement();
            String value=req.getHeader(name);
            System.out.println(name+"---"+value);
        }
    }
}
