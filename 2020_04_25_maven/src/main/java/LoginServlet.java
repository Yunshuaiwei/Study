import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/3 15:54
 * @Version
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的编码格式,响应的数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter pw = resp.getWriter();
        if("abc".equalsIgnoreCase(username)&&"123".equalsIgnoreCase(password)){
            pw.println("<p>登录成功！</p>");
        }else{
            pw.println("<p>登录不成功！</p>");
        }
        pw.flush();
    }
}
