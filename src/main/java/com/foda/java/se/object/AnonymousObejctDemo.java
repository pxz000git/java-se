package com.foda.java.se.object;

/**
 * 匿名对象:没有名字的对象
 * 匿名对象的应用场景：
 * 		当方法只调用一次的时候可以使用匿名对象
 * 		可以当作参数进行传递，但是无法在传参之前做其他的事情
 *
 * 注意：匿名对象可以调用成员变量并赋值，但是赋值并没有意
 * @author pxz
 * @date 2018/11/22 0022-下午 3:50
 */
public class AnonymousObejctDemo {
    public static void main(String[] args) {
        method(new People("张三",10));
    }
    public static void method(People people){

    }
}
class People{
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

    public People(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(String.format("name is %s, age is %d",name,age));
    }
}
