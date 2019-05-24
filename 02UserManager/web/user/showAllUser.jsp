<%@ page import="com.cyn.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    //可能需要导入tomcat的jar包
    String path = request.getContextPath();//当前项目名
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //basePath解决路径问题
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">查看所有用户信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <table class="tablelist">
        <thead>
        <tr>
            <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>生日</th>

        </tr>
        </thead>
        <tbody>
        <%
            List<User> userList = (ArrayList<User>)request.getAttribute("userList");
            for (User u : userList){
        %>
        <tr>
            <td><%=u.getUid()%></td>
            <td><%=u.getUname()%></td>
            <td><%=u.getPwd()%></td>
            <%
                String sex = u.getSex();
                //String sex="0";
                if (sex.equals("1")){
            %>
            <td>男</td>
            <%} else{ %>
            <td>女</td>
            <%}%>
            <td><%=u.getAge()%></td>
            <td><%=u.getBrith()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>

</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
