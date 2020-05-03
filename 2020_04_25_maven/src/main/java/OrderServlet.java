import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/3 17:24
 * @Version
 **/
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //身份验证，如果登录了则有session对象，否则没有session对象
        HttpSession s = req.getSession(false);
        if(s==null){//正常登录，则s不为null
            resp.sendRedirect(req.getContextPath()+"/index.html");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.println("<h2>登录成功！</h2>");
            writer.flush();
        }
    }
}
