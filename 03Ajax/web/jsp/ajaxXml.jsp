<%--
  Created by IntelliJ IDEA.
  User: 77560
  Date: 2019-05-29
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
需求：
1、在当前页面显示查询结果，使用ajax
2、创建ajax对象
3、调用ajax函数发送请求到UserServlet
4、调用业务层获取响应数据
-->
<script type="text/javascript">
    function getXml(){
        //创建ajax
        var ajax;
        if(window.XMLHttpRequest){
            ajax=new XMLHttpRequest();
        }else if(window.ActiveXObject) {
            ajax = new ActiveXObject("Msxml2.XMLHTTP");
        }
        //复写onreadystatechange
        ajax.onreadystatechange=function () {
            //判断ajax状态
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var result = ajax.responseXML;
                    alert(result.getElementsByTagName('uname')[0].innerHTML);
                }
            }
        }
        //发送请求
        ajax.open("get","/ajaxXmlServlet");
        ajax.send(null);
    }
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>测试xml</h3>
<hr>
<input type="button" value="测试xml" onclick="getXml()">

</body>
</html>
