package com.foda.java.se.mysql.dao.impl;

import com.foda.java.se.mysql.JDBCUtil;
import com.foda.java.se.mysql.User;
import com.foda.java.se.mysql.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pxz
 * @date 2018/11/23 0023-下午 5:56
 */
public class UserDaoImpl implements UserDao{
    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();

        //dao.update(3,"wangwu");
        //List<User> users = dao.select();
        //for (User user : users) {
        //    System.out.println(user);
        //}
        User user = dao.select(1);
        System.out.println(user);
        //dao.insert("zhangfei",20);
        //dao.delete(6);
    }

    // 连接相关
    private Connection connection = JDBCUtil.getConn();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void update(int id, String name) {
        //更新语句
        String sql = "update student set name=? where id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);

            int index = preparedStatement.executeUpdate();

            if(index>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //JDBCUtil.release(connection,preparedStatement);
        }
    }

    public List<User> select() {
        ArrayList<User> users = new ArrayList<User>();
        String sql = "select * from student";
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                user = new User();

                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                int id2 = resultSet.getInt("id");

                user.setId(id2);
                user.setAge(age);
                user.setName(name);
                if (user != null){
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return users;
    }

    public User select(int id){
        String sql = "select * from student where id= ?";
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                user = new User();

                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                int id2 = resultSet.getInt("id");

                user.setId(id2);
                user.setAge(age);
                user.setName(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return user;
    }

    public void delete(int id) {
        //删除语句
        String sql = "delete from student where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int index = preparedStatement.executeUpdate();

            if(index>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
    }

    public void insert(String name, int age) {
        //插入语句
        String sql = "insert into student values(null , ? , ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);

            int index = preparedStatement.executeUpdate();

            if(index>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
    }
}
