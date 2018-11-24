package com.foda.java.se.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author pxz
 * @date 2018/11/23 0023-下午 4:15
 */
public class CRUDDemo {

    // 连接相关
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        // 1.获取连接对象
        connection = JDBCUtil.getConn();

        //创建连接对象，获取statement
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //查询语句
        String sql_select = "select * from student";
        //新增语句
        String sql_insert = "insert into student values(null , 'wangSir' , 50)";
        //删除语句
        String sql_delete = "delete from student where name='wangSir'";
        //更新语句
        String sql_update = "update student set age = 26 where name ='wangwu'";
        //select(sql_select);
        //insert(sql_insert);
        //delete(sql_delete);
        //update(sql_update);
    }

    /**
     * 查询
     */
    public static void select(String sql) {

        try {
            resultSet = statement.executeQuery(sql);

            //遍历查询结果
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println(String.format("name is %s, age is %d", name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }


    }

    /**
     * 更新
     */
    public static void update(String sql) {
        try {
            int index = statement.executeUpdate(sql);

            //影响的行数， ，如果大于0 表明操作成功。 否则失败
            if(index > 0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,statement);
        }
    }

    /**
     * 新增
     */
    public static void insert(String sql) {
        try {
            int index = statement.executeUpdate(sql);

            //影响的行数， ，如果大于0 表明操作成功。 否则失败
            if(index > 0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,statement);
        }
    }

    /**
     * 删除
     */
    public static void delete(String sql) {
        try {
            int index = statement.executeUpdate(sql);
            if(index > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,statement);
        }

    }
}
