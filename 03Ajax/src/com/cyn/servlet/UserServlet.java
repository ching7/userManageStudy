package com.cyn.servlet;

import com.cyn.bean.User;
import com.cyn.service.UserService;
import com.cyn.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = req.getParameter("name");
        //处理请求信息
        try {
            User user =  userService.getUserInfoService(name);
            if (user!=null){
                System.out.println(user+"13123");
                //resp.getWriter().write("{uname:123}");
                resp.getWriter().write(user.toString());
                //resp.getWriter().write("var obj={};obj.name='zhangsan';");
                /*String toStringUser="";
                try {
                     toStringUser = new Gson().toJson(user);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.out.println("1231222222222");
                System.out.println(toStringUser);
                resp.getWriter().write(toStringUser);*/
            }else{
                System.out.println("用户不存在");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //响应请求数据

    }
}
