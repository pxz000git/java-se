package com.foda.java.se.object.static_test;

/**
 * 静态的方法中没有this 这个对象
 * 是因为静态方法在对象没有创建之前就已经跟着类加载出来了
 * @author pxz
 * @date 2018/11/22 0022-下午 1:54
 */
public class StaticDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();
    }
}
class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void study(){
        System.out.println("好好学习Java");
    }
}
