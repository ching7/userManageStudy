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
        $(function () {
            $("#fm").submit(function () {
                //alert($("#newPwd").val().trim());
                //校验新密码
                if($("#newPwd").val().trim() ==""){
                    alert('新密码不能为空');
                    return false;
                }else if($("#cfPwd").val().trim() ==""){
                    alert('确认密码不能为空');
                    return false;
                }else if($("#newPwd").val().trim()!=$("#cfPwd").val().trim()){
                    alert('两次密码不一致！');
                    return false;
                }else{
                    return true;
                }
            })
        })
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码信息</span></div>
    <%--target = "_top" 顶层显示--%>
    <form action="userServlet" method="post" id="fm" target="_top">
        <input type="hidden" name="oper" value="pwd">
        <ul class="forminfo">
            <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput" /></li>
            <li><label>确认密码</label><input name="cfPwd" id="cfPwd" type="text" class="dfinput" /></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
</div>


</body>

</html>

