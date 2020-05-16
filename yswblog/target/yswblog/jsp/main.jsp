<%--
  Created by IntelliJ IDEA.
  User: 17790
  Date: 2020/5/9
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <!-- jQuery -->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //alert("JSP文件")
            $.ajax({
                url:"login",//请求路径
                type:"post",//请求方式
                contentType:"application/json",//请求的数据格式
                data:{username:"abc",password:"123"},//请求的数据
                dataType:"json",//响应的数据格式
                success:function (data) {//返回的状态码200，调用这个函数

                }
            })
            $("#btn").click(function () {//绑定按钮点击事件
                alert("点击按钮");
            });
        });
    </script>
</head>
<body>
    <!--假设提交到后台的路径为http://localhost:8080/yswblog/login-->
    <!--现在访问到的路径为http://localhost:8080/yswblog/jsp/login,
    是以当前页面作为相对路径，加上请求路径-->
    <form action="login">
        <input type="text" name="username" placeholder="请输入用户名">
        <input type="password" name="password" placeholder="请输入密码">
        <input type="submit" value="提交">
    </form>
    <input id="btn" type="button" value="点击观看事件">
</body>
</html>
