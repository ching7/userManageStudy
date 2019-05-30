package com.cyn.dao.impl;

import com.cyn.bean.User;
import com.cyn.dao.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserInfoDao(String name) throws ClassNotFoundException {
        //声明储存对象
        User u = null;
        //声明jdbc对象
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf8","root","123");
            //创建sql对象
            String sql = "Select * from t_user where uname = ?";
            //创建sql命令
            preparedStatement = connection.prepareStatement(sql);
            //占位置赋值
            preparedStatement.setString(1,name);
            //sql执行
            System.out.println(name);
            System.out.println(sql);
            resultSet = preparedStatement.executeQuery();
            //遍历查询
            while (resultSet.next()){
                u = new User();
                u.setUid(resultSet.getInt("uid"));
                System.out.println(resultSet.getString("birth"));
                u.setAge(resultSet.getInt("age"));
                u.setBirth(resultSet.getString("birth"));
                u.setPwd(resultSet.getString("pwd"));
                u.setSex(resultSet.getString("sex"));
                u.setUname(resultSet.getString("uname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭资源
        return u;
    }
}
