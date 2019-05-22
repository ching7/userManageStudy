<%--
  Created by IntelliJ IDEA.
  User: 77560
  Date: 2019-05-16
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<div class="footer">
    <span>仅供学习交流，请勿用于任何商业用途</span>
    <i>版权所有 2014 chenyanan</i>
</div>
</body>
</html>
