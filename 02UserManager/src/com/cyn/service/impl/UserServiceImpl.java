package com.cyn.service.impl;

import com.cyn.dao.UserDao;
import com.cyn.dao.impl.UserDaoImpl;
import com.cyn.pojo.User;
import com.cyn.service.UserService;
import org.apache.log4j.Logger;


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
}
