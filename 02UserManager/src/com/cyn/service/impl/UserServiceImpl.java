package com.cyn.service.impl;

import com.cyn.dao.UserDao;
import com.cyn.dao.impl.UserDaoImpl;
import com.cyn.pojo.User;
import com.cyn.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;


public class UserServiceImpl implements UserService {
    //声明日志对象,注意是log4j的包
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    //声明Dao层对象
    UserDao userDao =  new UserDaoImpl();
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        //打印日志
        logger.debug(uname+":发起了登陆请求");
        User user = userDao.checkUserLoginDao(uname,pwd);
        //判断
        if (user!=null){
            logger.debug(uname+":登陆成功");
        }else {
            logger.debug(uname+":登陆失败");
        }
        return  user;
    }

    @Override
    public int userChangePwdService(int uid, String newPwd) {
        //打印日志
        logger.debug(uid + ":发起了密码修改请求");
        int index =  userDao.userChangePwdDao(uid,newPwd);
        if (index>0){
            logger.debug(uid + ":密码修改成功");

        }else {
            logger.debug(uid + ":密码修改失败");
        }
        return userDao.userChangePwdDao(uid,newPwd);
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public List<User> showAllUser() {
        //打印日志
        List<User> userList = userDao.showAllUserDao();
        logger.debug("显示所用用户信息："+userList);
        return userDao.showAllUserDao();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public int userRegService(User user) {

        return  userDao.userRegDao(user);
    }
}
