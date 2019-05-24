package com.cyn.dao.impl;

import com.cyn.dao.UserDao;
import com.cyn.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int userChangePwdDao(int uid, String newPwd) {
        //声明jdbc对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //创建变量
        int index = -1;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf8","root","123");
            //创建sql
            String sql = "update  t_user set pwd=? where uid =? ";
            //创建sql命令对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位值赋值
            preparedStatement.setString(1,newPwd);
            preparedStatement.setInt(2,uid);
            //执行
            index = preparedStatement.executeUpdate();
        }catch (Exception e){
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

        //返回结果
        return index;
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public List<User> showAllUserDao() {
        //声明jdbc对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //声明变量
        List<User> userList = new ArrayList<User>();
        User user = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf8","root","123");
            //创建sql
            String sql = "select * from t_user ";
            System.out.println(sql);
            //sql命令对象赋值
            preparedStatement = connection.prepareStatement(sql);
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
                userList.add(user);
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
        return userList;
    }

    @Override
    public int userRegDao(User user) {
        //声明jdbc对象
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        //声明变量
        int index = -1;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf8","root","123");
            //创建sql
            String sql = "insert into t_user values(default,?,?,?,?,?)";
            //创建 sql命令对象
            preparedStatement = connection.prepareStatement(sql);
            //占位置赋值
            preparedStatement.setString(1,user.getUname());
            preparedStatement.setString(2,user.getPwd());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.setString(5,user.getBrith());
            System.out.println(user);
            //执行
            index = preparedStatement.executeUpdate();
        }catch (Exception e){
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
        return index;
    }
}
