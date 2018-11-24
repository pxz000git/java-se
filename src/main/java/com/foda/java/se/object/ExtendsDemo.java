package com.foda.java.se.object;

/**
 * 继承中成员变量的特点
 * 		子类只能获取父类非私有成员
 * 		子父类中成员变量的名字不一样直接获取父类的成员变量
 * 		子父类中成员变量名字是一样的获取的是子类的成员变量
 *
 * 就近原则：谁离我近我就用谁
 * 		如果有局部变量就使用局部变量
 * 		如果没有局部变量，有子类的成员变量就使用子类的成员变量
 * 		如果没有局部变量和子类的成员变量，有父类的成员变量就使用父类的成员变量
 * 		啥都没有，出错了！！！
 *
 * super:可以获取父类的成员变量和成员方法,用法和this是相似的
 *
 * this和super的区别
 *  this:当前对象的引用
 *      调用子类的成员变量
 *      调用子类的成员方法
 *      在子类的构造方法第一行调用子类其他构造方法
 * super:子类对象的父类引用
 *      调用父类的成员变量
 *      调用父类的成员方法
 *      在子类的构造方法第一行调用父类的构造方法
 * 继承中构造方法的执行顺序
 * 			在子父类中，创建子类对象，调用子类的构造方法，
 * 			在子类的构造方法的第一行代码如果没有调用父类的构造或者没有调用子类的其他构造，则默认调用父类无参构造
 * 		   如果在第一行显式调用了，则不再隐式调用一次
 * 为什么要调用父类构造？
 * 			因为需要给父类的成员变量初始化
 * 肯定会先把父类的构造执行完毕，在去执行子类构造中的其他代码
 *
 * 我是父类无参构造 --- 我是子类有参构造 --- 我是子类无参构造
 * @author pxz
 * @date 2018/11/22 0022-下午 2:58
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        //C c = new C();
        //c.say();
        //D d = new D();
        //d.say();
        //B b = new B();
        //b.show();
        new B();
    }
}
class A{
    String name = "a";

    public A(){
        System.out.println("父类无参构造");
    }
    public A(String name){
        this.name = name;
        System.out.println("父类有参构造" + name);
    }
    public void say(){
        System.out.println("----A----");
    }
}
class B extends A{

    private String name = "b";

    public B(){
        super("abc");
        System.out.println("子类无参构造");
    }
    public B(String name){
        this.name = name;
        System.out.println("子类有参构造" + name);
    }
    public void show(){
        //String name = "b_show";

        System.out.println(String.format("a is %s",super.name));
        System.out.println(String.format("b is %s",this.name));
        System.out.println(String.format("b_show is %s",name));
    }
    @Override
    public void say() {
        System.out.println("---B-A>---");
    }
}
class C extends B{
    @Override
    public void say() {
        System.out.println("---C->B---");
    }
}
class D extends A{
    @Override
    public void say() {
        System.out.println("---D->A---");
    }
}