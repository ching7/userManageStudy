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
import java.util.List;

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
        System.out.println("操作符:"+oper);
        if (oper.equals("login")){
            //调用登陆处理
            checkUserLogin(req,resp);
        }else if (oper.equals("loginOut")){
            userLoginOut(req,resp);
        }else if(oper.equals("pwd")){
            userChangePwd(req,resp);
        }else if (oper.equals("showAllUser")){
            userShowAllUser(req,resp);
        }else if(oper.equals("reg")){
            userReg(req,resp);
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

    /**
     * 用户注册
     * @param req
     * @param resp
     */
    private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = req.getParameter("age")!=""?(Integer.parseInt( req.getParameter("age"))):0;

        String birth = req.getParameter("birth");
        if (!birth.equals("")){
            String[] tempStr =  birth.split("/");
            birth = tempStr[2]+"-"+tempStr[0] +"-"+tempStr[1];
        }else{
            birth = "2000-01-01";
        }
        System.out.println(birth);
        User user = new User();
        user.setUname(uname);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setAge(age);
        user.setBrith(birth);

        int index =  userService.userRegService(user);
        System.out.println(uname+":"+pwd+":"+sex+":"+":"+age+":"+birth);
        if (index>0){
            HttpSession session = req.getSession();
            session.setAttribute("reg",true);
            //重定向到登陆
            resp.sendRedirect("/index.jsp");
            return;
        }
    }

    /**
     * 显示所有用户信息
     * @param req
     * @param resp
     */
    private void userShowAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.showAllUser();
        if(userList!=null){
            //查询数据存储
            req.setAttribute("userList",userList);
            req.getRequestDispatcher("/user/showAllUser.jsp").forward(req,resp);
            return;
        }
    }

    /**
     * 修改用户密码
     * @param req
     * @param resp
     * @throws IOException
     */
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取新密码
        String newPwd = req.getParameter("newPwd");
        //session获取uid
        User user = (User)req.getSession().getAttribute("user");
        int uid = user.getUid();
        int index = userService.userChangePwdService(uid,newPwd);
        if (index>0){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("pwd","true");
            resp.sendRedirect("/index.jsp");
        }
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
