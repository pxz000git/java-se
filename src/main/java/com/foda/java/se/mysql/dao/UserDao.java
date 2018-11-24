package com.foda.java.se.mysql.dao;

import com.foda.java.se.mysql.User;

import java.util.List;


/**
 * @author pxz
 * @date 2018/11/23 0023-下午 5:52
 */
public interface UserDao {

    //根据id更新用户名
    void update(int id,String name);

    //根据id查询
    User select(int id);

    //查询所有
    List<User> select();


    //根据id删除用户
    void delete(int id);

    //执行添加
    void insert(String name,int age);
}
