<%@ page import="com.cyn.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: 77560
  Date: 2019-06-01
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<!--  使用传统方式，获取作用域对象数据 -->
<h3>EL表达式学习：传统方式获取数据</h3>
<b><%=request.getParameter("uname")%></b>
<hr>
<b><%=request.getAttribute("str")%></b>
<hr>
<b><%=((User)request.getAttribute("user")).toString()%>></b>
<hr>
<b><%=((ArrayList)request.getAttribute("list")).get(0)%></b>
<hr>
<b><%=((User)(((ArrayList)request.getAttribute("userList")).get(0))).getUname()%></b>
<hr>
<b><%=((HashMap)request.getAttribute("strMap")).get("杭州")%></b>
<hr>
<b><%=((User)((HashMap)request.getAttribute("userMap")).get("daYe")).getUname()%></b>

--%>

<%--
    EL表达式

    作用：获取作用域内的数据
    注意：获取的是pageContext,request,session,application 四个对象中的数据，其他以改不理会
    找到了则获取返回，找不到则什么都不做
    语法：${表达式}
        表达式：
            request对象：存储请求数据，----> param.键名 （一键一值）
            request对象：存储请求数据，----> paramValues.键名 （一键多值），返回数组

            setAttribute设置的数据
                ${键名} ----> 字符串直接返回
                ${键名} ----> 普通对象${键名.属性名}
                ${键名} ----> list集合${键名[角标]}
                ${键名} ----> map集合${键名.map集合储存的键名}


    作用域查找顺序：
    默认查找顺序：
    EL按作用域的大小去依次查找数据,找到就结束
    （注意作用域的持续时间）
        pageContext - request - session - application
    指定查找顺序：
        需要查找的作用域名+Scope

    EL表达式的逻辑运算：
        ${逻辑表达式}
        ${算数表达式}
        注: + 表示加法运算，不能表示字符拼接。字符拼接会报错
--%>
<h3>EL表达式学习：EL表达式（获取作用域的数据）</h3>
<b>${param.uname}</b>
<b>${paramValues.uname[1]}</b>
<hr>
<b>${str}</b>
<hr>
<b>${user}</b>
<hr>
<b>${list[0]}</b>
<hr>
<b>${userList[0].uname}</b>
<hr>
<b>${strMap.杭州}</b>
<hr>
<b>${userMap.daYe.uname}</b>

<h3>EL表达式学习：EL作用查找顺序</h3>
<%

    /*EL按作用域的大小去依次查找数据
    （注意作用域的持续时间）*/

    pageContext.setAttribute("hello","pageContext");
    request.setAttribute("hello","request");
    session.setAttribute("hello","session");
    application.setAttribute("hello","application");

%>
${hello}
${applicationScope.hello}

<h3>EL表达式的逻辑运算</h3>
${a+b}--${2+3}--${1*2}--${4/2}--${4-6}--${3%4}--${4==4}--${4>2}--${1+'222'}
