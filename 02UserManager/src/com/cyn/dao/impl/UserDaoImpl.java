package com.cyn.dao.impl;

import com.cyn.dao.UserDao;
import com.cyn.pojo.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //声明变量
        User user = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf8","root","123");
            //创建sql
            String sql = "select * from t_user where uname =? and pwd =?";
            //创建sql命令对象
            preparedStatement =connection.prepareStatement(sql);
            //占位符复制
            preparedStatement.setString(1,uname);
            preparedStatement.setString(2,pwd);
            System.out.println(sql);
            //执行sql
            resultSet  = preparedStatement.executeQuery();
            //遍历结果
            while (resultSet.next()){
                user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPwd(resultSet.getString("pwd"));
                user.setSex(resultSet.getString("sex"));
                user.setAge(resultSet.getInt("age"));
                user.setBrith(resultSet.getString("birth"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

        //返回结果
        return user;
    }
}
