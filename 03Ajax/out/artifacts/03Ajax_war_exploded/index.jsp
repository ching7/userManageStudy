<%--
  Created by IntelliJ IDEA.
  User: 77560
  Date: 2019-05-26
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
  Ajax学习：
    1.ajax概念
      局部刷新，多种技术的组合，浏览器端的技术
    2.ajax的作用
      实现在当前结果页中显示其他响应内容
    3.ajax的使用
      ajax的基本流程：
        //创建ajax引擎对象
        //复写onreadystatement
        //判断ajax状态码
        //获取响应内容
          //普通字符串
          //json
          //xml
        //处理响应结果（js操作文档结构）
      ajax的状态码：
        ajax的状态码：0，1，2，3，4 4表示响应内容被成功接受
        响应状态码：200 - 成功，404 - 资源未找到， 500 - 内部服务器错误
      ajax的异步和同步：
        ajax.open(method,url,async),async表示设置同步代码执行还是异步代码执行
        true 异步，false同步，默认异步执行
-->
<script type="text/javascript">
  function getData(){
      //创建ajax对象
      var ajax;
      //判断当前浏览器是否支持
      if(window.XMLHttpRequest){
          ajax = new XMLHttpRequest();
      }else if(window.ActiveXObject){
          //兼容低版本浏览器
          ajax = new ActiveXObject("Msxml2.XMLHTTP")
      }
      //复写onreadystatement函数
      //声明
      ajax.onreadystatechange = function () {
          //判断ajax响应码
          if(ajax.readyState==4){//获取请求数据，ajax，5个状态
              if(ajax.status==200){//正确响应
                  //获取响应内容
                  var result = ajax.responseText;
                  var div = document.getElementById("showDiv");
                  div.innerHTML=result;
              }else if(ajax.status==404){
                  var result = ajax.responseText;
                  var div = document.getElementById("showDiv");
                  div.innerHTML="请求不存在";
              }else if(ajax.status==500){
                  var result = ajax.responseText;
                  var div = document.getElementById("showDiv");
                  div.innerHTML="服务器繁忙";
              }
          }else{
              var result = ajax.responseText;
              var div = document.getElementById("showDiv");
              div.innerHTML="<img src='/img/load.gif' width='100px' height='100px'>";
          }
      }
      //发送请求
      ajax.open("get","ajaxServlet",true);
      ajax.send(null);
      alert("请求方式");
  }
  function ajaxReq(){
      var uname = document.getElementById("uname").value;
      var ajax;
      if(window.XMLHttpRequest){
          ajax = new XMLHttpRequest();
      }else if(window.ActiveXObject){
          //兼容低版本浏览器
          ajax = new ActiveXObject("Msxml2.XMLHTTP")
      }

      //复写onreadystatement
      ajax.onreadystatechange=function () {
          //判断ajax响应码
          if(ajax.status==4){
              if(ajax.status==200){
                  //获取响应内容
                  var result = ajax.responseText;
                  alert(result);
              }
          }
      }
      //发送请求
      //get方式
      /*ajax.open("get","ajaxServlet?name="+uname+"&pwd=123");
      ajax.send(null);*/
      //post方式
      ajax.open("post","ajaxServlet");
      //设置以键值对的方式传递数据enctype(form 表单类似的数据)
      ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded")
      ajax.send("name="+uname+"&pwd=123");
  }
</script>
<style type="text/css">
  #showDiv{
      border: solid 1px;
      height: 100px;
      width: 100px;
  }
</style>
<html>
  <head>
    <title>Ajax学习</title>
  </head>
  <body>
    <h3>欢迎登陆Ajax学习</h3>
    <hr>
    <input type="text" name="uname" value="" id="uname">
    <input type="button" value="测试" onclick="getData()">
    <input type="button" value="ajax测试" onclick="ajaxReq()">
    <div id="showDiv">
    </div>
  </body>
</html>
