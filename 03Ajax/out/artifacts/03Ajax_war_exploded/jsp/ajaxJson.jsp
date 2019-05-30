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
<script type="text/javascript" src="/js/ajaxUtil.js"></script>
<script type="text/javascript">
    function getData(){
        //获取用户请求信息
        var name = document.getElementById("uname").value;
        if (name==""){
            alert("请输入查询条件");
            return;
        }
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
                    var result = ajax.responseText;
                    /*alert(result);
                    alert(result);*/
                    eval("var obj="+result);
                    /*alert(obj.uname);*/
                    var ta = document.getElementById("ta");
                    ta.innerText="";
                    var tr = ta.insertRow(0);
                    var cell0=tr.insertCell(0);
                    cell0.innerHTML="编号";
                    var cell1=tr.insertCell(1);
                    cell1.innerHTML="姓名";
                    var cell2=tr.insertCell(2);
                    cell2.innerHTML="密码";
                    var cell3=tr.insertCell(3);
                    cell3.innerHTML="性别";
                    var cell4=tr.insertCell(4);
                    cell4.innerHTML="年龄";
                    var cell5=tr.insertCell(5);
                    cell5.innerHTML="生日";

                    var tr = ta.insertRow(1);
                    var cell0=tr.insertCell(0);
                    cell0.innerHTML=obj.uid;
                    var cell1=tr.insertCell(1);
                    cell1.innerHTML=obj.uname;
                    var cell2=tr.insertCell(2);
                    cell2.innerHTML=obj.pwd;
                    var cell3=tr.insertCell(3);
                    cell3.innerHTML=obj.sex;
                    var cell4=tr.insertCell(4);
                    cell4.innerHTML=obj.age;
                    var cell5=tr.insertCell(5);
                    cell5.innerHTML=obj.date;
                }
            }
        }
        //发送请求
        ajax.open("get","/userServlet?name="+name);
        ajax.send(null);
        //alert("请求方式");

    }
    function getData2() {
        var name = document.getElementById("uname").value;
        var data = "name="+name;
        myAjax("get","/userServlet",data,function (f) {
                var rs = f.responseText;
                alert(rs)
        },true);
    }

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>欢迎访问英雄商店</h3>
    <hr>
    英雄名称: <input type="text" name="uname" id="uname">
    <input type="button" value="搜索" onclick="getData()">
    <hr>
    <table border="1px" id="ta">
        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>性别</td>
        <td>年龄</td>
        <td>生日</td>
    </table>
</body>
</html>
