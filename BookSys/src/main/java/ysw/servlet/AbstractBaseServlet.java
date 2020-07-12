package ysw.servlet;

import ysw.exception.BaseException;
import ysw.model.ResponseResult;
import ysw.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 21:01
 * @Version
 **/
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ResponseResult r = new ResponseResult();

        try {
            Object process = process(req, resp);
            r.setSuccess(true);
            r.setCode("200");
            r.setMessage("操作成功！");
            r.setData(process);
        } catch (Exception e) {
            if (e instanceof BaseException) {
                BaseException be = (BaseException) e;
                r.setCode(be.getCode());
                r.setMessage(be.getMessage());
            } else {
                r.setCode("500");
                r.setMessage("未知错误！");
            }
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            r.setStackTrace(sw.toString());
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.write(r));
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
