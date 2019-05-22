package com.cyn.servlet;

import com.cyn.pojo.User;
import com.cyn.service.UserService;
import com.cyn.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    //声明日志对象
    Logger logger = Logger.getLogger(UserServlet.class);
    UserService userService =  new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //获取请求操作符
        String oper  = req.getParameter("oper");
        if (oper.equals("login")){
            //调用登陆处理
            checkUserLogin(req,resp);
        }else if (oper.equals("reg")){
            //调用注册处理
        }else if (oper.equals("loginOut")){
            userLoginOut(req,resp);
        }else{
            logger.debug("未找到对应操作符");
            System.out.println("未找到对应操作符");
        }
        //处理请求信息
        //响应请求信息
            //直接响应
            //请求转发
            //重定向
    }

    private void userLoginOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession httpSession = req.getSession();
        //销毁
        httpSession.invalidate();
        //重定向
        resp.sendRedirect("/index.jsp");
    }

    //处理登陆
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求信息
            //获取service对象
        User user =  userService.checkUserLoginService(uname,pwd);
        if (user!=null){
            //获取session对象
            HttpSession httpSession = req.getSession();
            //将用户放入session
            httpSession.setAttribute("user",user);
            //重定向
            //绝对路径：首个/是服务器根目录： /项目名/文件位置
            //相对路径可能受到servlet别名带路径的影响，因为是从当前请求的路径查找，导致重定向出错
            resp.sendRedirect("/main/main.jsp");
        }else{
            //请求转发，方便数据处理
            try {
                req.setAttribute("flag",0);
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            //resp.sendRedirect("/index.jsp");
            return;
        }
            //校验用户是否存在
        //响应请求信息
        //直接响应
        //请求转发
        //重定向

    }
}
