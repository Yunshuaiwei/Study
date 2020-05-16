package yswblog.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 20:14
 * @Version
 **/
@WebServlet("/count")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<p>map</p>");
        ConcurrentMap<String, AtomicInteger> map = AbstractBaseServlet.getMAP();
        for (Map.Entry<String, AtomicInteger> entry : map.entrySet()) {
            pw.println("<p>");
            pw.println("路径:"+entry.getKey()+",次数:"+entry.getValue());
            pw.println("</p>");
        }
        pw.flush();

    }
}
