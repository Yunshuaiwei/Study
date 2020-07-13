package ysw.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/13 9:57
 * @Version
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = req.getServletPath();
        if ("/login.html".equals(path) || path.startsWith("/public/") || path.startsWith("/static/")
                || "/user/login".equals(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = req.getSession(false);
            if (session == null) {
                String scheme = req.getScheme();
                String host = req.getServerName();
                int port = req.getServerPort();
                String contextPath = req.getContextPath();
                String basePath = scheme + "://" + host + ":" + port + contextPath;
                ((HttpServletResponse) servletResponse).sendRedirect(basePath + "/public/index.html");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
