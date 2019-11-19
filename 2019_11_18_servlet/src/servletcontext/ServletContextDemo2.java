package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
/**
 * @author
 */
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1、通过HttpServlet获取
        ServletContext context =this.getServletContext();

        //2、定义文件名称
        String filename="a.jpg";
        //3、获取MIME类型
        String mimeType=context.getMimeType(filename);
        System.out.println(mimeType);


        //所有用户请求的数据
        ServletContext context3=this.getServletContext();
        //获取数据
        Object msg=context3.getAttribute("msg");
        System.out.println(msg);


        //获取文件的服务器路径
        ServletContext context4=this.getServletContext();
        String realPath=context4.getRealPath("/a.txt");
        System.out.println(realPath);
//        File file=new File(realPath);
        //src目录下的资源访问
        String a=context.getRealPath("/WEB-INF/classes/b.txt");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
