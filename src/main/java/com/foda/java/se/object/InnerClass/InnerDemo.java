package com.foda.java.se.object.InnerClass;

/**
 * 成员内部类：
 * 		在类的成员位置，和成员变量以及成员方法所在的位置是一样的
 * 		在内部类当中，可以直接访问外部类的成员，包括私有成员
 * 成员内部类的修饰符：
 * 		我们可以使用权限修饰符修饰成员内部类，但是如果使用私有来修饰，则无法在其他类中访问
 * 		我们可以使用static修饰成员内部类，不用再创建外部类的对象了
 *
 * 我们可以使用abstract,final修饰成员内部类
 * @author pxz
 * @date 2018/11/22 0022-下午 3:58
 */
public class InnerDemo {
    public static void main(String[] args) {
        //new Outer().method();

        //new Outer().new Inner().func();

        //Outer2.Inner2.func();

        new Outer3().method();
    }
}
class Outer{
    private int num = 10;
    public void method(){
        System.out.println("外部类方法");
        new Inner().func();
    }
    class Inner{
        void func(){
            System.out.println("内部类方法");
            System.out.println(num);
        }
    }
}
class Outer2{
    private int num = 10;
    public void method(){
        System.out.println("外部类方法");
        //new Inner2().func();
    }
    static class Inner2{
        static void func(){
            System.out.println("内部类方法");
        }
    }
}

/**
 * 局部内部类:
 * 		在方法内，出了方法之后就无法使用
 */
class Outer3{
    private int num = 10;
    public void method(){
        System.out.println("外部类方法");

        class Inner3{
            void func(){
                System.out.println("内部类方法");
            }
        }
        Inner3 inner3 = new Inner3();
        inner3.func();
    }
    public void test(){
        //访问不了，出域了
        //Outer.Inner inner = new Outer.Inner();
    }

}