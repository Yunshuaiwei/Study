package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请方式
        String method = request.getMethod();
        System.out.println(method);
        //2、获取虚拟目录
        String path=request.getContextPath();
        System.out.println(path);
        //3、获取Servlet路径
        String servletPath=request.getServletPath();
        System.out.println(servletPath);
        //4、获取get方式请求参数
        String name=request.getQueryString();
        System.out.println(name);
        //5、获取请求URI
        String uri=request.getRequestURI();
        StringBuffer url=request.getRequestURL();
        System.out.println(uri);
        System.out.println(url);
        //6、获取协议及版本
        String protocol=request.getProtocol();
        System.out.println(protocol);
        //7、获取客户机的IP地址
        String remoteAddr=request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
