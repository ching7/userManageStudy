package com.cyn.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "ajaxServlet",urlPatterns = "/ajax")
@WebServlet("/ajaxServlet")

public class AjaxServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求响应编码格式
        req.setCharacterEncoding("utf-8");
        //设置应答编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        //获取请求信息
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name +":"+pwd+":"+req.getMethod());
        //处理请求信息
        //返回响应信息
        //int b = 3/0;
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        resp.getWriter().write("天气在下雨");
    }
}
