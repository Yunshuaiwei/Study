package yswblog.servlet;

import yswblog.exception.BaseException;
import yswblog.model.Result;
import yswblog.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 18:24
 * @Version
 **/
public abstract class AbstractBaseServlet extends HttpServlet {
    //统计访问次数
    private static final ConcurrentMap<String, Integer> MAP = new ConcurrentHashMap<>();

    private static final ConcurrentMap<String, AtomicInteger> MAP2 = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        //前端约定的统一json数据格式
        Result result = new Result();
        try {
            //正确返回业务数据
            Object data = process(req, resp);
            result.setSuccess(true);
            result.setData(data);
        } catch (Exception e) {//捕获到异常，需要设置前端需要的错误信息
            if (e instanceof BaseException) {
                BaseException be = (BaseException) e;
                result.setMessage("错误码：" + be.getCode() + "，错误信息：" + be.getMessage());
            } else {
                result.setMessage("服务器异常：未知的错误！");
            }
            StringWriter sw = new StringWriter();
            PrintWriter epw = new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();

        String path = req.getServletPath();
//        synchronized (MAP) {
//            if (MAP.containsKey(path)) {
//                Integer integer = MAP.get(path);
//                integer++;
//                MAP.put(path, integer);
//            } else {
//                MAP.put(path, 1);
//            }
//        }
        if (MAP2.containsKey(path)) {
            AtomicInteger integer = MAP2.get(path);
            integer.incrementAndGet();
            MAP2.put(path, integer);
        } else {
            MAP2.put(path, new AtomicInteger(1));
        }
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp)
            throws Exception;
}
