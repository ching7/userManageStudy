<%--
  Created by IntelliJ IDEA.
  User: ching
  Date: 2019/6/5
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    注意：
    导入jar
    jstl
    standard
    且tomcat上需要有一份

    JSTL学习:
        作用：
            提高在JSP中的代码逻辑处理效率，使用标签
        使用：
            JSTL核心标签库
            JSTL格式化标签库
            JSTLSQL标签库
            JSTL函数标签库
            JSTLXML标签库
        JSTL核心标签库：
            1、导入jar
            2、声明JSTL标签库的引入（核心标签库）
            <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
            3、内容：
                <c:out value="数据" default="默认值"></c:out>
                数据可以结合EL表达式取值,输出数据到客户端

                <c:set var="键" value="值" scope="作用域"></c:set>
                存储数据到作用域

--%>
<%
    request.setAttribute("testStr","JSTL测试");
%>
<h3>JSTL测试</h3>
<c:out value="哈哈"></c:out> <br>
<c:out value="${testStr}" default="testStr不存在"></c:out> <%--el表达式--%> <br>
<c:out value="${testStr2}" default="testStr2不存在"></c:out> <%--el表达式--%> <br>
<br>
<hr>
<h4>向作用域存值</h4>
<%--
    存在覆盖,取最新 (不设置scope)
    默认pageContext (设置scope)

    可以指定作用域
--%>
<c:set var="testSet" value="hello pageContext" scope="page"></c:set>
<c:set var="testSet" value="hello request" scope="request"></c:set>
<c:set var="testSet" value="hello session" scope="session"></c:set>
<c:set var="testSet" value="hello application" scope="application"></c:set>
<c:out value="${testSet}"></c:out> <br>
<c:out value="${sessionScope.testSet}"></c:out>