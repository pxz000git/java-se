package com.foda.java.se.object.block;

/**
 * @author pxz
 * @date 2018/11/22 0022-下午 1:58
 */
public class BlockDemo {
    public static void main(String[] args) {
        //局部代码块：存在于方法中，控制变量的生命周期（作用域）
        //for (int i =0; i<10; i++){
        //    System.out.println("我爱Java");
        //}
        //
        //int num = 10;
        //System.out.println(num);

        new Teacher();
        new Teacher("小苍老师",18);
    }

}

class Teacher{
    private String name;
    private int age;

    //构造代码块：提取构造方法中的共性，每次创建对象都会执行
    //并且在构造方法之前执行
    {
        for(int x = 0;x < 3;x++) {
            System.out.println("我爱Java");
        }
    }
    //静态代码块：随着类的加载而加载，只加载一次，加载类时需要做的一些初始化，比如加载驱动
    static {
        System.out.println("我爱--Java");
    }

    public Teacher(){
        System.out.println("无参构造方法");
    }
    public Teacher(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("有参构造方法");
    }
}