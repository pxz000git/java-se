package com.foda.java.se.object;

/**
 * abstract:关键字，用于修饰方法和类
 * 抽象类不能创建对象（不能实例化）
 * 抽象类中可以有非抽象的方法
 * 抽象类和类的关系也是继承
 * 抽象方法：不同类的方法是相似，但是具体内容又不太一样，所以我们只能抽取他的声明，没有具体的方法体，没有具体方法体的方法就是抽象方法
 * 抽象类：有抽象方法的类必须是抽象类
 * 注意：一个类继承了抽象类需要重写他所有的抽象方法,否则这个类就得是抽象类
 * 抽象类的成员特点：
 * 		成员变量
 * 			可以有成员变量
 * 			可以有常量
 * 		成员方法
 * 			可以有抽象方法
 * 			可以有非抽象方法
 * 		构造方法
 * 			可以有构造方法的，需要对抽象类的成员变量进行初始化
 * final:修饰类、成员变量、成员方法
 * @author pxz
 * @date 2018/11/22 0022-下午 2:15
 */
public class AbstractDemo {
    public static void main(String[] args) {
        new Cat();
        Cat cat = new Cat();
        cat.eat();
        cat.run();
        //new Animal();
    }
}

abstract class Animal{
    String name = "小猫";
    final int num = 10;

    public Animal(){
        System.out.println("抽象方法的构造方法");
    }

    public abstract void eat();

    //非抽象方法，其子类可以不重写
    public void run(){
        System.out.println("跑步...");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫在吃。。。");
    }
}

