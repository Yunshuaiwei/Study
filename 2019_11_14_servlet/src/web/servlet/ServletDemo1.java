package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName Study
 * @ClassName ServletDemo1
 * Description
 * @Auther YunSW
 * @Date 2019/11/14 10:47
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

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
