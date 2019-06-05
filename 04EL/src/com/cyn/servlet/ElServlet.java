package com.cyn.servlet;

import com.cyn.bean.Address;
import com.cyn.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问题：
 *  servlet 处理请求后，使用作用域对象将数据返回给对应的jsp文件
 *  jsp中怎么获取数据
 *
 *  使用：
 *      传统方式：使用java脚本段语句在jsp页面中
 *
 */
@WebServlet("/elServlet")
public class ElServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        //处理请求信息
        System.out.println(uname +":" + pwd);
        //返回处理数据
            //使用request作用域流转数据
            // 1 普通字符串
            req.setAttribute("str","晚上适合学习！！");
            // 2 对象
            User user = new User();
            user.setUname("李武");
            user.setUid(1);
            user.setAddr(new Address("浙江","杭州","滨江"));
            user.setFav("电影");
            req.setAttribute("user",user);
            // 3 List集合
            // 1) string 集合
            List<String> list = new ArrayList<String>();
            list.add("王二麻子");
            list.add("李狗蛋");
            list.add("王春花");
            req.setAttribute("list",list);
            // 2) 对象集合
            User user1 = new User();
            user1.setUname("与大爷");
            User user2 = new User();
            user2.setUname("桃儿");
            List<User> userList = new ArrayList<User>();
            userList.add(user1);
            userList.add(user2);
            req.setAttribute("userList",userList);
            //4 Map 集合
                //普通字符串
                Map<String,String> strMap = new HashMap<String,String>();
                strMap.put("杭州","996");
                req.setAttribute("strMap",strMap);
                //对象
                Map<String,User> strMap1 = new HashMap<String,User>();
                strMap1.put("daYe",user1);
                req.setAttribute("userMap",strMap1);
            //空值判断：
                req.setAttribute("emptyStr","");
                req.setAttribute("emptyUser",new User());
                req.setAttribute("emptyUserList",new ArrayList<>());

        //直接响应
            //请求转发
            req.getRequestDispatcher("/el.jsp").forward(req,resp);
            //重定向
    }
}
