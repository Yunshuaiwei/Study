package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName Study
 * @ClassName ServletDemo1
 * Description
 * @Auther YunSW
 * @Date 2019/11/13 10:18
 * @Version 1.0
 **/
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
