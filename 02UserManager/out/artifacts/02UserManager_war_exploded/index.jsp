<%--
  Created by IntelliJ IDEA.
  User: 77560
  Date: 2019-05-14
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    //可能需要导入tomcat的jar包
    String path = request.getContextPath();//当前项目名
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //basePath解决路径问题
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>
    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>
</head>
<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>
<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>
<div class="loginbody">
    <span class="systemlogo" style="margin-top: 5%"></span>
    <div class="loginbox loginbox1">
        <form action="/userServlet" method="post">
            <input type="hidden" name="oper" value="login">
            <ul>
                <li><span>
                    <%
                        if (request.getAttribute("flag")!=null){
                    %>
                    用户名或密码错误
                    <%
                        }

                    %>
                    <%
                        if (request.getSession().getAttribute("pwd")!=null){
                            session.removeAttribute("pwd");
                    %>
                    密码修改成功
                    <%
                        }

                    %>
                    <%
                        if (request.getSession().getAttribute("reg")!=null){
                            session.removeAttribute("reg");
                    %>
                    注册成功
                    <%
                        }

                    %>
                </span></li>
            <%--value="密码" onclick="JavaScript:this.value=''"--%>
                <li><input name="uname" type="text" class="loginuser" placeholder="用户名"/></li>
                <li><input name="pwd" type="password" class="loginpwd"  placeholder="密码" /></li>
                <li class="yzm">
                    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><a
                        href="/user/regist.jsp">注册</a></label><label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>
    </div>
</div>
<div class="loginbm">版权所有  2019 chenyanan  <a href="#">ching</a>  仅供学习交流，勿用于任何商业用途</div>
</body>
</html>

