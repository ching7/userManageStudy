package com.cyn.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxXmlServlet",urlPatterns = "/ajaxXmlServlet")
public class AjaxXmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求响应编码格式
        req.setCharacterEncoding("utf-8");
        //设置应答编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/xml");
        //获取请求信息
        //处理请求信息
        //返回响应信息
        resp.getWriter().write("<user><uid>1</uid><uname>测试</uname></user>");
    }
}
